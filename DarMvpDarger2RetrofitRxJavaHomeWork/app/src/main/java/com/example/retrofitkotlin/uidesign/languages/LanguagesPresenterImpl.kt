package com.example.retrofitkotlin.uidesign.languages

import android.app.Application
import android.os.AsyncTask
import android.util.Log
import android.widget.Toast
import com.example.retrofitkotlin.ApplicationClass
import com.example.retrofitkotlin.data.LanguageModel
import com.example.retrofitkotlin.data.LanguageModelStore
import com.example.retrofitkotlin.network.RetrofitApiInterfaceNetwork
import com.example.retrofitkotlin.uidesign.Preseneter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LanguagesPresenterImpl(var postView: LanguagesView, var applicationComponent: Application) : LanguagesPresenter, Preseneter<LanguagesView>(postView) {

    @Inject
    lateinit var mNetworkApi: RetrofitApiInterfaceNetwork

    init {
        (applicationComponent as ApplicationClass).applicationComponent.inject(this)
    }

    override fun getAllPosts() {
        var view = view()

        view?.let {
            it.showLoading()
            var allPosts = mNetworkApi.getallLanguage()
            addDisposable(allPosts.subscribeOn(IoScheduler()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            { result ->
                                view?.let {
                                    it.hideLoading()
                                    postView.showAllPosts(result)

                                }
                            },
                            { error ->
                                view?.let {
                                    it.hideLoading()
                                }
                            }
                    ) ) }

        var allPosts = mNetworkApi.getallLanguage()

        allPosts.subscribeOn(IoScheduler()).observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    postView.showAllPosts(it)
                }

    }

    inner class StoreLanguage(private var context: LanguagesActivity,private var newlanguage: String) : AsyncTask<Void, Void, Boolean>() {
        override fun doInBackground(vararg params: Void?): Boolean {

            val languageStore = LanguageModelStore(newlanguage)
            mNetworkApi!!.storelanguage(languageStore).enqueue(object : Callback<LanguageModel> {
                override fun onResponse(call: Call<LanguageModel>, response: Response<LanguageModel>) {
                    Log.i("", "post submitted to API." + response.body()!!)

                    if (response.isSuccessful()) {
                        val language = response.body()
                        Log.i("", "post registration to API" + response.body()!!.toString())
                        Log.i("", "name" + response.body()!!.name)
                        Log.i("", "created_at" + response.body()!!.created_at)

//                        if (language != null) {
//                            myLanguageArrayList?.add(language)
//                        }
//                        recycler_view.adapter?.notifyDataSetChanged()
                    }
                }
                override fun onFailure(call: Call<LanguageModel>, t: Throwable) {
                }
            })
            return true
        }

        override fun onPostExecute(bool: Boolean?) {
            if (bool!!) {
                Toast.makeText(context, "New Language stored succesfully", Toast.LENGTH_LONG).show()
            }
        }
    }


    inner class DeleteLanguage(private var context: LanguagesActivity,private var position: Int) : AsyncTask<Void, Void, Boolean>() {
        override fun doInBackground(vararg params: Void?): Boolean {
            mNetworkApi.deleteLanguage(position).enqueue(object : Callback<LanguageModel> {
                override fun onResponse(call: Call<LanguageModel>, response: Response<LanguageModel>) {
//                    myLanguageArrayList?.removeAt(position)
//                    recycler_view.adapter?.notifyItemRemoved(position)
                }
                override fun onFailure(call: Call<LanguageModel>, t: Throwable) {
                }
            })
            return true
        }

        override fun onPostExecute(bool: Boolean?) {
            if (bool!!) {
                Toast.makeText(context, "Deleted", Toast.LENGTH_LONG).show()
            }
        }
    }

    inner class UpdateLanguage(private var context: LanguagesActivity,private var position: Int,private var updatetext:String,private var pos_id:Int): AsyncTask<Void,Void,Boolean>(){
        override fun doInBackground(vararg params: Void?): Boolean {
            val languageStore = LanguageModelStore(updatetext)

            mNetworkApi!!.updateLanguage(pos_id,languageStore).enqueue(object : Callback<LanguageModel> {
                override fun onResponse(call: Call<LanguageModel>, response: Response<LanguageModel>) {
                    Log.i("", "post submitted to API." + response.body()!!)
                    //myLanguageArrayList?.removeAt(position)
                    if (response.isSuccessful()) {

                        val language = response.body()
                        Log.i("", "post registration to API" + response.body()!!.toString())
                        Log.i("", "name" + response.body()!!.name)
                        Log.i("", "created_at" + response.body()!!.created_at)

//                        if (language != null) {
//                            myLanguageArrayList?.add(position,language)
//                        }
//                        recycler_view.adapter?.notifyDataSetChanged()
                    }
                }
                override fun onFailure(call: Call<LanguageModel>, t: Throwable) {
                }
            })
            return true
        }

        override fun onPostExecute(bool: Boolean?) {
            if (bool!!) {
                Toast.makeText(context, "Updated", Toast.LENGTH_LONG).show()
            }
        }
    }


}