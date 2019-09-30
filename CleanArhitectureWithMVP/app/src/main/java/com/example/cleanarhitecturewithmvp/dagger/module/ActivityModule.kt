package com.example.cleanarhitecturewithmvp.dagger.module


import com.example.cleanarhitecturewithmvp.mvp.roomLanguages.LanguagesMVPActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector()
    abstract fun bindMainActivity(): LanguagesMVPActivity
}