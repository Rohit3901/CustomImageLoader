package com.example.imageloader.ui.main.photos

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.customimageloader.DoubleCache
import com.example.customimageloader.ImageLoader
import com.example.imageloader.R
import com.example.imageloader.data.remote.response.PhotosResponse
import com.example.imageloader.di.component.ViewHolderComponent
import com.example.imageloader.ui.base.BaseItemViewHolder
import com.example.imageloader.utils.log.Logger
import kotlinx.android.synthetic.main.item_layout.view.*

class PhotoItemViewHolder (parent:ViewGroup):
        BaseItemViewHolder<PhotosResponse,PhotoItemViewModel>(R.layout.item_layout,parent){


    override fun injectDependencies(viewHolderComponent: ViewHolderComponent) {
        viewHolderComponent.inject(this)
    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.image.observe(this, Observer {
            it.run {
                ImageLoader.setCache(DoubleCache(itemView.item_imageView.context))
                ImageLoader.displayImage(this, itemView.item_imageView)

            }
        })
    }

    override fun setupView(view: View) {

    }

}
