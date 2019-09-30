package com.example.kotlinarhitecturecomponents.dagger.module

import android.app.Application
import com.example.kotlinarhitecturecomponents.mvvm.logic.LanguagesViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class InjectorUtils {

    @Provides
    @Singleton
    fun provideLanguagesViewModelFactory(application: Application): LanguagesViewModelFactory {
        return LanguagesViewModelFactory(application)
    }
}