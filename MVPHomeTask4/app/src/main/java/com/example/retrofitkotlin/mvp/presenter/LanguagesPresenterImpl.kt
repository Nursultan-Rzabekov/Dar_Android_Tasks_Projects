package com.example.retrofitkotlin.mvp.presenter

import android.app.Application
import com.example.retrofitkotlin.ApplicationClass
import com.example.retrofitkotlin.data.LanguageRoomDB
import com.example.retrofitkotlin.network.RetrofitApiInterfaceNetwork
import com.example.retrofitkotlin.mvp.Presenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler
import javax.inject.Inject

class LanguagesPresenterImpl(var postView: LanguagesView, applicationComponent: Application) : LanguagesPresenter, Presenter<LanguagesView>(postView) {
    @Inject
    lateinit var mNetworkApi: RetrofitApiInterfaceNetwork

    init {
        (applicationComponent as ApplicationClass).applicationComponent.inject(this)
    }

    override fun getAllPosts() {
        val view = view()
        view?.let {
            it.showLoading()
            val allPosts = mNetworkApi.getAllLanguage()
            addDisposable(allPosts.subscribeOn(IoScheduler()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            {result ->
                                    it.hideLoading()
                                    postView.showAllPosts(result)
                            },
                            { _ ->
                                    it.hideLoading()
                            }
                    ) ) }
    }

    override fun storePosts(store: String) {
        val view = view()
        view?.let {
            val languageModel = LanguageRoomDB(store)
            val storePosts = mNetworkApi.storeLanguage(languageModel)
            addDisposable(storePosts.subscribeOn(IoScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result ->
                            it.hideLoading()
                            postView.storePost(result!!)

                    },
                    { _ ->
                        it.hideLoading()

                    }
                ))
        }
    }

    override fun updatePosts(position: Int,store: String,db_position:Int) {
        val view = view()
        view?.let {
            val languageModel = LanguageRoomDB(store)
            val updatePosts = mNetworkApi.updateLanguage(db_position,languageModel)
            addDisposable(updatePosts.subscribeOn(IoScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { _ ->
                            it.hideLoading()
                            postView.updatePost(position,languageModel)
                    },
                    { _ ->
                            it.hideLoading()
                    }
                ))
        }

    }

    override fun deletePosts(position: Int) {
        val view = view()
        view?.let {
            val deletePost = mNetworkApi.deleteLanguage(position)
            addDisposable(deletePost.subscribeOn(IoScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { _ ->
                            it.hideLoading()
                            postView.deletePost(position)
                    },
                    { _ ->
                            it.hideLoading()
                    }
                ))
        }
    }
}