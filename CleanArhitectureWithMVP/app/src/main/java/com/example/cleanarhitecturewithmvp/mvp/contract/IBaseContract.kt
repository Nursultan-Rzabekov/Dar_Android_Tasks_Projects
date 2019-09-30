package com.example.cleanarhitecturewithmvp.mvp.contract

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle


interface IBaseContract {

    interface View {
        fun showProgressDialog(content: String)
        fun dismissProgressDialog()
        fun getProgressDialog(content: String): ProgressDialog
        fun showErrorToast(message: String)
        fun showWarningToast(message: String)
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter<V : IBaseContract.View> {
        val context: Context?
        fun onSaveInstanceState(outState: Bundle)
        fun onRestoreInstanceState(outState: Bundle)
        fun attachView(view: V)
        fun detachView()
        fun onViewInitialized()
    }
}
