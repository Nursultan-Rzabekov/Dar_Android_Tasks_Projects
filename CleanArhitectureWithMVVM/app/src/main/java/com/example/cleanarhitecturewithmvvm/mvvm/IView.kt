package com.example.cleanarhitecturewithmvvm.mvvm

interface IView{
    fun showLoading()
    fun hideLoading()
    fun loadError(e: Throwable)
    fun loadError(msg: String)
}