package com.example.cleanarhitecturewithmvp.dagger.component


import android.app.Application
import android.content.Context
import com.example.cleanarhitecturewithmvp.ApplicationClass
import com.example.cleanarhitecturewithmvp.dagger.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules =
    [AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        ActivityModule::class,
        UseCaseModule::class,
        RoomModule::class,
        NetworkModule::class,
        DataModule::class
    ])

interface ApplicationComponent : AndroidInjector<ApplicationClass> {
    @Component.Builder
    interface Builder {

        fun build(): ApplicationComponent

        @BindsInstance
        fun application(application: Application): Builder
    }
    fun context(): Context
}