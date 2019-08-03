package com.example.cleanarhitecturewithmvp.dagger.component


import com.example.cleanarhitecturewithmvp.ApplicationClass
import com.example.cleanarhitecturewithmvp.dagger.module.AppModule
import com.example.cleanarhitecturewithmvp.dagger.module.RoomModule
import com.example.cleanarhitecturewithmvp.dagger.module.UseCaseModule
import com.example.cleanarhitecturewithmvp.mvp.roomLanguages.RoomLanguagesPresenterImpl
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class,UseCaseModule::class,RoomModule::class])
interface ApplicationComponent {

    fun inject(mewApplication: ApplicationClass)
    
    fun inject(mPostPresenterImpl: RoomLanguagesPresenterImpl)
}

