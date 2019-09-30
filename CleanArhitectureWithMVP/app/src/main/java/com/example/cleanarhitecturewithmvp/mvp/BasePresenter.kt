package com.example.cleanarhitecturewithmvp.mvp

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import moxy.MvpPresenter
import timber.log.Timber
import java.io.PrintWriter
import java.io.StringWriter
import kotlin.coroutines.CoroutineContext

abstract class BasePresenter<T:IView> : MvpPresenter<T>(), CoroutineScope {

    companion object {
        private val EXCEPTION_HANDLER = CoroutineExceptionHandler { _, exception ->
            val stringWriter = StringWriter().also {
                PrintWriter(it).use { exception.printStackTrace(it) }
            }
            Timber.e("${stringWriter.buffer}")
        }
    }

    private var job: Job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job + EXCEPTION_HANDLER

}