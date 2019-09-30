package com.example.kotlinarhitecturecomponents.mvvm.logic

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.kotlinarhitecturecomponents.domain.model.Language
import com.example.kotlinarhitecturecomponents.extension.State
import io.reactivex.disposables.CompositeDisposable

class LanguagesListViewModel : ViewModel() {

    var newsList: LiveData<PagedList<Language>>
    private val compositeDisposable = CompositeDisposable()
    private val pageSize = 5
    private val newsDataSourceFactory: LanguagesDataSourceFactory

    init {
        newsDataSourceFactory =
            LanguagesDataSourceFactory(compositeDisposable)

        val config = PagedList.Config.Builder()
                .setPageSize(pageSize)
                .setInitialLoadSizeHint(pageSize * 2)
                .setEnablePlaceholders(false)
                .build()

        newsList = LivePagedListBuilder(newsDataSourceFactory, config).build()
    }

    fun getState(): LiveData<State> = Transformations.switchMap<LanguagesRemoteDataSource, State>(newsDataSourceFactory.newsDataSourceLiveData, LanguagesRemoteDataSource::state)

    fun retry() {
        newsDataSourceFactory.newsDataSourceLiveData.value?.retry()
    }

    fun listIsEmpty(): Boolean {
        return newsList.value?.isEmpty() ?: true
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}