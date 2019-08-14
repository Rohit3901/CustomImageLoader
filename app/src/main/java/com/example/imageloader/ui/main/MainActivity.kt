package com.example.imageloader.ui.main


import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.imageloader.R
import com.example.imageloader.di.component.ActivityComponent
import com.example.imageloader.ui.base.BaseActivity
import com.example.imageloader.ui.main.photos.PhotoAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity :BaseActivity<MainViewModel>(){


    @Inject
    lateinit var linearLayoutManager: GridLayoutManager

    @Inject
    lateinit var photoAdapter:PhotoAdapter


    override fun provideLayoutId(): Int =R.layout.activity_main

    override fun injectDependencies(activityComponent: ActivityComponent) {
       activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {
        recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = photoAdapter
        }
    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.loading.observe(this, Observer {
            progressBar.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.posts.observe(this, Observer {
            it.data?.run { photoAdapter.appendData(this) }
        })
    }

}