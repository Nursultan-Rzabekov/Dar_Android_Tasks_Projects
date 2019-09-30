package com.example.cleanarhitecturewithmvp

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.os.Build
import com.example.cleanarhitecturewithmvp.dagger.component.ApplicationComponent
import com.example.cleanarhitecturewithmvp.dagger.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber


class ApplicationClass : DaggerApplication() {

    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .application(this)
            .build()
        return applicationComponent

    }


    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            //TODO: Logic for crashlitics
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
            cm?.registerDefaultNetworkCallback(object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {

                }
            })
        }

    }
}