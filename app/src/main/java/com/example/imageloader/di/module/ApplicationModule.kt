package com.example.imageloader.di.module

import android.app.Application
import android.content.Context
import com.example.imageloader.BuildConfig
import com.example.imageloader.MyApplication
import com.example.imageloader.data.remote.NetworkService
import com.example.imageloader.data.remote.Networking
import com.example.imageloader.di.ApplicationContext
import com.example.imageloader.utils.network.NetworkHelper
import com.example.imageloader.utils.rx.RxSchedulerProvider
import com.example.imageloader.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: MyApplication) {

    @Provides
    @Singleton
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(): Context = application

    /**
     * Since this function do not have @Singleton then each time CompositeDisposable is injected
     * then a new instance of CompositeDisposable will be provided
     */
    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = RxSchedulerProvider()

    @Provides
    @Singleton
    fun provideNetworkService(): NetworkService =
        Networking.create(
            BuildConfig.BASE_URL
        )
    @Singleton
    @Provides
    fun provideNetworkHelper(): NetworkHelper = NetworkHelper(application)
}
