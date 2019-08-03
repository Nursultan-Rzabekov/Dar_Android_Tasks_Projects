package com.example.maybecleanarhitecturewithmvp

import android.app.Application
import com.example.maybecleanarhitecturewithmvp.dagger.component.ApplicationComponent
import com.example.maybecleanarhitecturewithmvp.dagger.module.UseCaseModule


open class ApplicationClass : Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

//        applicationComponent = DaggerApplicationComponent.builder()
//                .build()

        applicationComponent.inject(this)
    }
}