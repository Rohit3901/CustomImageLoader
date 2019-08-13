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

/*

class MainActivity : AppCompatActivity() {

    private val imageList = arrayListOf(
        "https://images.pexels.com/photos/1722183/pexels-photo-1722183.jpeg?dl&fit=crop&crop=entropy&w=1280&h=1920",
        "https://images.pexels.com/photos/1667580/pexels-photo-1667580.jpeg?dl&fit=crop&crop=entropy&w=1280&h=1920",
        "https://images.pexels.com/photos/1470405/pexels-photo-1470405.jpeg?dl&fit=crop&crop=entropy&w=1280&h=853",
        "https://images.pexels.com/photos/1005417/pexels-photo-1005417.jpeg?dl&fit=crop&crop=entropy&w=1280&h=1600",
        "https://images.pexels.com/photos/1294671/pexels-photo-1294671.jpeg?dl&fit=crop&crop=entropy&w=1280&h=1920",
        "https://images.pexels.com/photos/1040893/pexels-photo-1040893.jpeg?dl&fit=crop&crop=entropy&w=1280&h=1919",
        "https://images.pexels.com/photos/1956974/pexels-photo-1956974.jpeg?dl&fit=crop&crop=entropy&w=1280&h=853",
        "https://images.pexels.com/photos/1374064/pexels-photo-1374064.jpeg?dl&fit=crop&crop=entropy&w=1280&h=1706",
        "https://images.pexels.com/photos/1931142/pexels-photo-1931142.jpeg?dl&fit=crop&crop=entropy&w=1280&h=1919",
        "https://images.pexels.com/photos/1295036/pexels-photo-1295036.jpeg?dl&fit=crop&crop=entropy&w=1280&h=1707",
        "https://images.pexels.com/photos/1320684/pexels-photo-1320684.jpeg?dl&fit=crop&crop=entropy&w=1920&h=1440",
        "https://images.pexels.com/photos/1908677/pexels-photo-1908677.jpeg?dl&fit=crop&crop=entropy&w=1280&h=1706"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView?.layoutManager = GridLayoutManager(this, 2)
        recyclerView?.adapter = ImageAdapter(imageList, this)

    }
}
*/

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