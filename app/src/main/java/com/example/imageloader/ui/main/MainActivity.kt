package com.example.imageloader.ui.main


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.customimageloader.ImageLoader
import com.example.imageloader.R
import com.example.imageloader.di.component.ActivityComponent
import com.example.imageloader.ui.base.BaseActivity
import com.example.imageloader.ui.fullImage.FullImageActivity
import com.example.imageloader.ui.main.photos.PhotoAdapter
import com.example.imageloader.utils.display.Toaster
import com.example.imageloader.utils.log.Logger
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel>() {


    @Inject
    lateinit var linearLayoutManager: GridLayoutManager

    @Inject
    lateinit var photoAdapter: PhotoAdapter


    override fun provideLayoutId(): Int = R.layout.activity_main

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {
        recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = photoAdapter
        }

        floatingActionButton.setOnClickListener {
            viewModel.stopCall()
        }

        photoAdapter.itemSelectionListener = {
            position, data ->  viewModel.openImage(data.urls.regular)
        }


    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.loading.observe(this, Observer {
              if (it) {
                  progressBar.visibility=  View.VISIBLE
            } else {
                  progressBar.visibility= View.GONE
                 // floatingActionButton.hide()
            }

        })

        viewModel.posts.observe(this, Observer {
            it.data?.run { photoAdapter.appendData(this) }
        })

        viewModel.stoploading.observe(this, Observer {
            if (it) {
                progressBar.visibility = View.GONE
                Toaster.show(applicationContext, "Loading canceled")

                //Clear the cache on cancel the on flight request
                //ImageLoader.clearCache()
            }
        })

        viewModel.launchImage.observe(this, Observer {
            it.getIfNotHandled()?.run {
                startActivity(Intent(applicationContext,FullImageActivity::class.java).putExtra("URL",this))
            }
        })
    }

}