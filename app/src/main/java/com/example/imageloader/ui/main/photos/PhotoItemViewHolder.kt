package com.example.imageloader.ui.main.photos

import android.view.View
import android.view.ViewGroup
import com.example.imageloader.R
import com.example.imageloader.data.remote.response.PhotosResponse
import com.example.imageloader.di.component.ViewHolderComponent
import com.example.imageloader.ui.base.BaseItemViewHolder

class PhotoItemViewHolder (parent:ViewGroup):
        BaseItemViewHolder<PhotosResponse,PhotoItemViewModel>(R.layout.item_layout,parent){

    override fun injectDependencies(viewHolderComponent: ViewHolderComponent) {
        viewHolderComponent.inject(this)
    }

    override fun setupObservers() {
        super.setupObservers()
    }

    override fun setupView(view: View) {

    }
}