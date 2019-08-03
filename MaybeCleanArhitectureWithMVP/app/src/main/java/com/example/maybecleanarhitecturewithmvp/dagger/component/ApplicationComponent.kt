package com.example.maybecleanarhitecturewithmvp.dagger.component


import com.example.maybecleanarhitecturewithmvp.ApplicationClass
import com.example.maybecleanarhitecturewithmvp.dagger.module.AppModule
import com.example.maybecleanarhitecturewithmvp.dagger.module.NetworkModule
import com.example.maybecleanarhitecturewithmvp.dagger.module.UseCaseModule
import com.example.maybecleanarhitecturewithmvp.mvp.roomLanguages.RoomLanguagesPresenterImpl
import dagger.Component

@Component(modules = [AppModule::class,UseCaseModule::class])
interface ApplicationComponent {
    fun inject(mewApplication: ApplicationClass)
    fun inject(mPostPresenterImpl: RoomLanguagesPresenterImpl)

}