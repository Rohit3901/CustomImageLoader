package com.example.imageloader.ui.fullImage

import com.example.imageloader.ui.base.BaseViewModel
import com.example.imageloader.utils.network.NetworkHelper
import com.example.imageloader.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class FullImageViewModel (
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
    ):BaseViewModel(schedulerProvider, compositeDisposable, networkHelper){




    override fun onCreate() {

    }

}