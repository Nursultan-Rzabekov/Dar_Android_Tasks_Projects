package com.example.cleanarhitecturewithmvvm.dagger.component


import com.example.cleanarhitecturewithmvvm.ApplicationClass
import com.example.cleanarhitecturewithmvvm.dagger.module.*
import com.example.cleanarhitecturewithmvvm.mvvm.logic.LanguagesMVVMActivity
import com.example.cleanarhitecturewithmvvm.mvvm.logic.LanguagesViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class,UseCaseModule::class,RoomModule::class,NetworkModule::class,DataModule::class,InjectorUtils::class])
interface ApplicationComponent {

    fun inject(mewApplication: ApplicationClass)

    fun inject(mPostViewModel: LanguagesViewModel)

    fun inject(languagesMVVMActivity: LanguagesMVVMActivity)
}