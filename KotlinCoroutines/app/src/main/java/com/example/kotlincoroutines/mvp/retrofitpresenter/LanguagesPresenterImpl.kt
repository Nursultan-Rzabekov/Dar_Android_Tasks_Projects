package com.example.kotlincoroutines.mvp.retrofitpresenter

import android.app.Application
import com.example.kotlincoroutines.ApplicationClass
import com.example.kotlincoroutines.RemoteDataNotFoundException
import com.example.kotlincoroutines.ReposRefreshError
import com.example.kotlincoroutines.data.LanguageRoomDB
import com.example.retrofitkotlin.network.RetrofitApiInterfaceNetwork
import kotlinx.coroutines.*
import javax.inject.Inject

class LanguagesPresenterImpl(var postView: LanguagesView, applicationComponent: Application) : LanguagesPresenter {
    @Inject
    lateinit var mNetworkApi: RetrofitApiInterfaceNetwork

    init {
        (applicationComponent as ApplicationClass).applicationComponent.inject(this)
    }

    override fun getAllPosts() = runBlocking{
        try {
            this.launch(Dispatchers.IO){
                val allPosts = mNetworkApi.getAllLanguage()
                postView.showAllPosts(allPosts)
            }

        } catch (error: RemoteDataNotFoundException){
            throw  ReposRefreshError(error)
        }
    }

    override fun storePosts(store: String) = runBlocking {
        try{
            this.launch(Dispatchers.IO){
                val languageModel = LanguageRoomDB(store)
                val storePosts = mNetworkApi.storeLanguage(languageModel)
                postView.storePost(storePosts)
            }
        }catch (error: RemoteDataNotFoundException){
            throw  ReposRefreshError(error)
        }
    }

    override fun updatePosts(position: Int,store: String,db_position:Int) = runBlocking {
        try {
            this.launch(Dispatchers.IO){
                val languageModel = LanguageRoomDB(store)
                val model = mNetworkApi.updateLanguage(db_position,languageModel)
                postView.updatePost(position,model)
            }
        }catch (error: RemoteDataNotFoundException){
            throw  ReposRefreshError(error)
        }
    }

    override fun deletePosts(position: Int,db_position: Int)  = runBlocking{
        try {
            this.launch(Dispatchers.IO){
                mNetworkApi.deleteLanguage(db_position)
                postView.deletePost(position)
            }
        }catch (error: RemoteDataNotFoundException){
            throw  ReposRefreshError(error)
        }
    }
}