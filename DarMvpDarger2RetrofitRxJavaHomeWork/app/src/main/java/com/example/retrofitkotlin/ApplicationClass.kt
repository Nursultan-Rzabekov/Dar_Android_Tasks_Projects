package com.example.retrofitkotlin

import android.app.Application
import com.example.retrofitkotlin.dagger.component.ApplicationComponent
import com.example.retrofitkotlin.dagger.component.DaggerApplicationComponent
import com.example.retrofitkotlin.dagger.module.NetworkModule


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