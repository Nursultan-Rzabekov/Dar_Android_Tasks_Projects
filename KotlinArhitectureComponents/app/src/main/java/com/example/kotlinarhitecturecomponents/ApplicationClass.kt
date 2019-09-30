package com.example.kotlinarhitecturecomponents

import android.app.Application
import com.example.kotlinarhitecturecomponents.dagger.component.ApplicationComponent
import com.example.kotlinarhitecturecomponents.dagger.component.DaggerApplicationComponent
import com.example.kotlinarhitecturecomponents.dagger.module.*


open class ApplicationClass : Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
                .useCaseModule(UseCaseModule())
                .roomModule(RoomModule())
                .networkModule(NetworkModule())
                .dataModule(DataModule())
                .injectorUtils(InjectorUtils())
                .appModule(AppModule(this))
                .build()

        applicationComponent.inject(this)
    }
}