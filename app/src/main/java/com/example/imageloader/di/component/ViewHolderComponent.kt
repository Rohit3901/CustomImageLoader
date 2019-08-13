package com.example.imageloader.di.component

import com.example.imageloader.di.ViewModelScope
import com.example.imageloader.di.module.ViewHolderModule
import com.example.imageloader.ui.main.photos.PhotoItemViewHolder


import dagger.Component

@ViewModelScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ViewHolderModule::class]
)
interface ViewHolderComponent {
    fun inject(viewHolder:PhotoItemViewHolder)
 }