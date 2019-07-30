package com.example.kotlincoroutines.mvp

interface IView{
    fun showLoading()
    fun hideLoading()
    fun loadError(e: Throwable)
    fun loadError(msg: String)
}