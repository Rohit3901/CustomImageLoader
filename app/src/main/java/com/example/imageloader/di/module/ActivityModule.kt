package com.example.imageloader.di.module

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imageloader.data.repository.PhotoRepository
import com.example.imageloader.ui.base.BaseActivity
import com.example.imageloader.ui.main.MainViewModel
import com.example.imageloader.ui.main.photos.PhotoAdapter
import com.example.imageloader.utils.ViewModelProviderFactory
import com.example.imageloader.utils.network.NetworkHelper
import com.example.imageloader.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @Provides
    fun provideLinearLayoutManager(): GridLayoutManager = GridLayoutManager(activity,2)

    @Provides
    fun provideMainViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        photoRepository: PhotoRepository
    ): MainViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(MainViewModel::class) {
            MainViewModel(schedulerProvider, compositeDisposable, networkHelper,photoRepository,ArrayList())
        }).get(MainViewModel::class.java)

    @Provides
    fun providePhotoAdapter() = PhotoAdapter(activity.lifecycle, ArrayList())

}