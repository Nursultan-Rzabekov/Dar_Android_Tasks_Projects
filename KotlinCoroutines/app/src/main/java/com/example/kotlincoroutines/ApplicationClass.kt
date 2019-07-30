package com.example.kotlincoroutines

import android.app.Application
import com.example.kotlincoroutines.dagger.component.ApplicationComponent
import com.example.kotlincoroutines.dagger.component.DaggerApplicationComponent
import com.example.kotlincoroutines.dagger.module.NetworkModule



open class ApplicationClass : Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
                .networkModule(NetworkModule())
                .build()

        applicationComponent.inject(this)
    }
}