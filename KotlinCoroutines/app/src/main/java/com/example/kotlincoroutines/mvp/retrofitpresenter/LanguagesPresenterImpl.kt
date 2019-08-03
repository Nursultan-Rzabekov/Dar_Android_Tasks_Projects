package com.example.kotlincoroutines.mvp.retrofitpresenter

import android.app.Application
import com.example.kotlincoroutines.ApplicationClass
import com.example.kotlincoroutines.RemoteDataNotFoundException
import com.example.kotlincoroutines.ReposRefreshError
import com.example.kotlincoroutines.data.LanguageRoomDB
import com.example.retrofitkotlin.network.RetrofitApiInterfaceNetwork
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class LanguagesPresenterImpl(var postView: LanguagesView, applicationComponent: Application) : LanguagesPresenter,CoroutineScope {

    private var viewModelJob = Job()
    override val coroutineContext: CoroutineContext
        get() = viewModelJob + Dispatchers.Main

    @Inject
    lateinit var mNetworkApi: RetrofitApiInterfaceNetwork

    init {
        (applicationComponent as ApplicationClass).applicationComponent.inject(this)
    }

    override fun getAllPosts() =
        try {
            this.launch(Dispatchers.IO){
                val allPosts = mNetworkApi.getAllLanguage()
                withContext(coroutineContext){
                    postView.showAllPosts(allPosts)
                }
            }

        } catch (error: RemoteDataNotFoundException){
            throw  ReposRefreshError(error)
        }

    override fun storePosts(store: String) =
        try{
            this.launch(Dispatchers.IO){
                val languageModel = LanguageRoomDB(store)
                val storePosts = mNetworkApi.storeLanguage(languageModel)
                withContext(coroutineContext){
                    postView.storePost(storePosts)
                }

            }
        }catch (error: RemoteDataNotFoundException){
            throw  ReposRefreshError(error)
        }

    override fun updatePosts(position: Int,store: String,db_position:Int) =
        try {
            this.launch(Dispatchers.IO){
                val languageModel = LanguageRoomDB(store)
                val model = mNetworkApi.updateLanguage(db_position,languageModel)
                withContext(coroutineContext){
                    postView.updatePost(position,model)
                }
            }
        }catch (error: RemoteDataNotFoundException){
            throw  ReposRefreshError(error)
        }


    override fun deletePosts(position: Int,db_position: Int)  =
        try {
            this.launch(Dispatchers.IO){
                mNetworkApi.deleteLanguage(db_position)
                withContext(coroutineContext){
                    postView.deletePost(position)
                }
            }
        }catch (error: RemoteDataNotFoundException){
            throw  ReposRefreshError(error)
        }

    internal fun onDestroy(){
        coroutineContext.cancel()
    }
}