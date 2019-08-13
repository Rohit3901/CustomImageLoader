package com.example.imageloader.ui.main.photos

import com.example.imageloader.data.remote.response.PhotosResponse
import com.example.imageloader.ui.base.BaseItemViewHolder
import com.example.imageloader.ui.base.BaseItemViewModel
import com.example.imageloader.utils.network.NetworkHelper
import com.example.imageloader.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PhotoItemViewModel @Inject constructor(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
    ):BaseItemViewModel<PhotosResponse>(schedulerProvider, compositeDisposable, networkHelper){


    override fun onCreate() {}


}