package com.example.imageloader

import android.app.Application
import com.example.imageloader.di.component.ApplicationComponent
import com.example.imageloader.di.component.DaggerApplicationComponent
import com.example.imageloader.di.module.ApplicationModule

class MyApplication:Application(){

    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }

}