package com.example.cleanarhitecturewithmvp

import android.app.Application
import com.example.cleanarhitecturewithmvp.dagger.component.ApplicationComponent
import com.example.cleanarhitecturewithmvp.dagger.component.DaggerApplicationComponent
import com.example.cleanarhitecturewithmvp.dagger.module.*


open class ApplicationClass : Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
                .useCaseModule(UseCaseModule())
                .roomModule(RoomModule())
                .networkModule(NetworkModule())
                .dataModule(DataModule())
                .appModule(AppModule(this))
                .build()

        applicationComponent.inject(this)
    }
}