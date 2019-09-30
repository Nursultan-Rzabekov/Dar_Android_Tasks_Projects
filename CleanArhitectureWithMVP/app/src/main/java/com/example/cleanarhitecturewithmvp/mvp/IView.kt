package com.example.cleanarhitecturewithmvp.mvp

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface IView : MvpView {
    fun showLoading()
    fun hideLoading()
    fun loadError(e: Throwable)
    fun loadError(msg: String)
}