package com.example.cleanarhitecturewithmvp.mvp

import android.app.ProgressDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import com.example.cleanarhitecturewithmvp.R
import dagger.android.support.DaggerAppCompatActivity
import moxy.MvpDelegate


abstract class BaseActivity : DaggerAppCompatActivity(), IView {

    private var mProgressDialog: ProgressDialog?=null
    private var mvpDelegate: MvpDelegate<out BaseActivity>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayout())
        initializeProgressDialog()
        init(savedInstanceState)
        getMvpDelegate().onCreate(savedInstanceState)

    }

    private fun initializeProgressDialog(){
        if(mProgressDialog==null) {
            mProgressDialog =  ProgressDialog(this)
            mProgressDialog!!.isIndeterminate = true
            mProgressDialog!!.setCancelable(false)
        }

    }

    override fun onStart() {
        super.onStart()
        getMvpDelegate().onAttach()
    }

    override fun onResume() {
        super.onResume()
        getMvpDelegate().onAttach()
    }

    override fun onStop() {
        super.onStop()
        getMvpDelegate().onDetach()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        getMvpDelegate().onSaveInstanceState(outState)
        getMvpDelegate().onDetach()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

    }

    override fun onDestroy() {
        super.onDestroy()
        System.gc()
        System.runFinalization()
        dismissProgress()
        mProgressDialog=null
        getMvpDelegate().onDestroyView()
    }

    @LayoutRes
    abstract fun setLayout():Int
    abstract fun init(savedInstanceState: Bundle?)
    abstract fun onStartScreen()
    abstract fun stopScreen()

    fun showProgress(msgResId: Int, keyListener: DialogInterface.OnKeyListener?) {
        if (isFinishing)
            return
        if (mProgressDialog!!.isShowing) {
            return
        }
        if (msgResId != 0) {
            mProgressDialog?.setMessage(resources.getString(msgResId))
        }
        if (keyListener != null) {
            mProgressDialog?.setOnKeyListener(keyListener)
        } else {
            mProgressDialog?.setCancelable(false)
        }
        mProgressDialog?.show()
    }

    private fun dismissProgress() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog?.dismiss()
        }
    }

    override fun hideLoading() {
        dismissProgress()
    }

    override fun showLoading() {
        showProgress(R.string.loading, null)
    }

    override fun loadError(e: Throwable) {
        showHttpError(e)
    }

    override fun loadError(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    private fun showHttpError(e: Throwable) {
      loadError(e.localizedMessage)
    }


    fun getMvpDelegate(): MvpDelegate<*> {
        if (mvpDelegate == null) {
            mvpDelegate = MvpDelegate(this)
        }
        return mvpDelegate!!
    }

}