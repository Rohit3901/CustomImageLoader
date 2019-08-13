package com.example.imageloader.di.module

import androidx.lifecycle.LifecycleRegistry
import com.example.imageloader.di.ViewModelScope
import com.example.imageloader.ui.base.BaseItemViewHolder
import dagger.Module
import dagger.Provides

@Module
class ViewHolderModule(private val viewHolder: BaseItemViewHolder<*, *>) {

    @Provides
    @ViewModelScope
    fun provideLifecycleRegistry(): LifecycleRegistry = LifecycleRegistry(viewHolder)
}