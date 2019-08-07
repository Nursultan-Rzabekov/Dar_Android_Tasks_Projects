package com.example.cleanarhitecturewithmvvm.mvvm.helpers

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class LocationListener(val lifecycle: Lifecycle, private val callback: (String) -> Unit) : LifecycleObserver {

    private var enabled = false

    var status = ""

    init {
        lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {
        if (enabled) {
            status = CONNECTED
            callback.invoke("Somewhere in Los Angeles")
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop() {
        if (enabled) {
            status = DISCONNECTED
            callback.invoke("Activity stopped")
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroy() {
        lifecycle.removeObserver(this)
        callback.invoke("GoodBuy MyActivity")
    }

    fun enable() {
        enabled = true
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            start()
        }
    }

    companion object {
        const val CONNECTED = "Connected"
        const val DISCONNECTED = "Disconnected"
    }
}