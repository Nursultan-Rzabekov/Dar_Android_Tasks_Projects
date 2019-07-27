package com.example.retrofitkotlin.dagger.component

import com.example.retrofitkotlin.ApplicationClass
import com.example.retrofitkotlin.dagger.module.AppModule
import com.example.retrofitkotlin.dagger.module.NetworkModule
import com.example.retrofitkotlin.mvp.presenter.LanguagesPresenterImpl
import dagger.Component

@Component(modules = [AppModule::class, NetworkModule::class])
interface ApplicationComponent {
    fun inject(mewApplication: ApplicationClass)
    fun inject(mPostPresenterImpl: LanguagesPresenterImpl)

}