package com.example.cleanarhitecturewithmvvm

import android.app.Application
import com.example.cleanarhitecturewithmvvm.dagger.component.ApplicationComponent
import com.example.cleanarhitecturewithmvvm.dagger.component.DaggerApplicationComponent
import com.example.cleanarhitecturewithmvvm.dagger.module.*


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