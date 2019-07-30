package com.example.kotlincoroutines.dagger.component


import com.example.kotlincoroutines.ApplicationClass
import com.example.kotlincoroutines.dagger.module.AppModule
import com.example.kotlincoroutines.dagger.module.NetworkModule
import com.example.kotlincoroutines.mvp.retrofitpresenter.LanguagesPresenterImpl
import dagger.Component

@Component(modules = [AppModule::class, NetworkModule::class])
interface ApplicationComponent {
    fun inject(mewApplication: ApplicationClass)
    fun inject(mPostPresenterImpl: LanguagesPresenterImpl)

}