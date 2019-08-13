package com.example.imageloader.ui.main

import androidx.lifecycle.MutableLiveData
import com.example.imageloader.data.remote.response.PhotosResponse
import com.example.imageloader.data.repository.PhotoRepository
import com.example.imageloader.ui.base.BaseViewModel
import com.example.imageloader.utils.network.NetworkHelper
import com.example.imageloader.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val photoRepository: PhotoRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    val loading: MutableLiveData<Boolean> = MutableLiveData()
    val posts: MutableLiveData<List<PhotosResponse>> = MutableLiveData()


    init {

        loading.postValue(true)
        compositeDisposable.addAll(
            photoRepository.fetchPhotos()
                .subscribeOn(schedulerProvider.io())
                .subscribe(
                    {

                        loading.postValue(false)
                    },
                    {
                        loading.postValue(false)
                    }
                )
        )
    }

    override fun onCreate() {}
}