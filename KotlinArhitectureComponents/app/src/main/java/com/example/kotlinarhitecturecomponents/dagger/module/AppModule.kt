package com.example.kotlinarhitecturecomponents.dagger.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(application: Application) {

    private var applicationInst: Application = application

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return applicationInst
    }
}