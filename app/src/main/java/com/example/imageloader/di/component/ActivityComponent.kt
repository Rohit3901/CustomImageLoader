package com.example.imageloader.di.component

import com.example.imageloader.ui.main.MainActivity
import com.example.imageloader.di.ActivityScope
import com.example.imageloader.di.module.ActivityModule
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    fun inject(activity: MainActivity)


}