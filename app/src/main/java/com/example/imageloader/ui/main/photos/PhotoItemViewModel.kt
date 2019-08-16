package com.example.imageloader.ui.main.photos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.imageloader.data.remote.response.PhotosResponse
import com.example.imageloader.ui.base.BaseItemViewHolder
import com.example.imageloader.ui.base.BaseItemViewModel
import com.example.imageloader.utils.log.Logger
import com.example.imageloader.utils.network.NetworkHelper
import com.example.imageloader.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PhotoItemViewModel @Inject constructor(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
    ):BaseItemViewModel<PhotosResponse>(schedulerProvider, compositeDisposable, networkHelper){


    val itemClick:MutableLiveData<PhotosResponse> = MutableLiveData()

    val image: LiveData<String> = Transformations.map(data){
        Logger.e("url",it.urls.regular)
        it.urls.regular.run { this }
    }

    override fun onCreate() {}

    fun onImageClicked(){
        itemClick.postValue(data.value)
    }


}