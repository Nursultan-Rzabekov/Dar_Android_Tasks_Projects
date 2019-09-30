package com.example.kotlinarhitecturecomponents.data.source

import androidx.paging.PageKeyedDataSource
import com.example.kotlinarhitecturecomponents.data.model.LanguageEntity
import com.example.kotlinarhitecturecomponents.data.repository.LanguageDataStore
import com.example.kotlinarhitecturecomponents.data.repository.LanguageRoom
import com.example.kotlinarhitecturecomponents.extension.State
import com.example.kotlinarhitecturecomponents.remote.model.LanguageRemoteModel
import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action


class LanguageDataStoreFactory (private val languageRoom: LanguageRoom,
                                private val languageRoomDataStore: LanguageRoomDataStore,
                                private val languageRemoteDataStore: LanguageRemoteDataStore,
                                private val compositeDisposable: CompositeDisposable) : PageKeyedDataSource<Int, LanguageEntity>(){

    private var retryCompletable: Completable? = null

    suspend fun retrieveDataStore(): LanguageDataStore {
        if (!languageRoom.isCached()) {
            return retrieveRoomDataStore()
        }
        return retrieveRemoteDataStore()
    }

    internal fun retrieveRoomDataStore(): LanguageDataStore {
        return languageRoomDataStore
    }

    private fun retrieveRemoteDataStore(): LanguageDataStore {
        return languageRemoteDataStore
    }


    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, LanguageEntity>) {
        compositeDisposable.add(languageRemoteDataStore.getAllLanguage(1, params.requestedLoadSize)
                .subscribe(
                    { response ->
                        callback.onResult(response,
                            null,
                            2
                        )
                    },
                    {
                        setRetry(Action { loadInitial(params, callback) })
                    }
                )
        )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, LanguageEntity>) {
        compositeDisposable.add(languageRemoteDataStore.getAllLanguage(1, params.requestedLoadSize)
                .subscribe(
                    { response ->
                        callback.onResult(response,
                            params.key + 1
                        )
                    },
                    {
                        setRetry(Action{ loadAfter(params, callback) })
                    }
                )
        )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, LanguageEntity>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun setRetry(action: Action?) {
        retryCompletable = if (action == null) null else Completable.fromAction(action)
    }

}