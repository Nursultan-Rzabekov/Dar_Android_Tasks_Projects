package com.example.kotlinarhitecturecomponents.dagger.component


import com.example.kotlinarhitecturecomponents.ApplicationClass
import com.example.kotlinarhitecturecomponents.dagger.module.*
import com.example.kotlinarhitecturecomponents.mvvm.logic.LanguagesMVVMActivity
import com.example.kotlinarhitecturecomponents.mvvm.logic.LanguagesViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class,UseCaseModule::class,RoomModule::class,NetworkModule::class,DataModule::class,InjectorUtils::class])
interface ApplicationComponent {

    fun inject(mewApplication: ApplicationClass)

    fun inject(mPostViewModel: LanguagesViewModel)

    fun inject(languagesMVVMActivity: LanguagesMVVMActivity)

}