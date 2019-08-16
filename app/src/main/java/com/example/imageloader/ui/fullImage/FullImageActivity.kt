package com.example.imageloader.ui.fullImage

import android.os.Bundle
import com.example.customimageloader.ImageLoader
import com.example.imageloader.R
import com.example.imageloader.di.component.ActivityComponent
import com.example.imageloader.ui.base.BaseActivity
import kotlinx.android.synthetic.main.full_viewlayout.*

class FullImageActivity :BaseActivity<FullImageViewModel>(){
    override fun provideLayoutId(): Int = R.layout.full_viewlayout

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupObservers() {
        super.setupObservers()

    }

    override fun setupView(savedInstanceState: Bundle?) {
        ImageLoader.displayImage(intent.getStringExtra("URL"),imageView)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}