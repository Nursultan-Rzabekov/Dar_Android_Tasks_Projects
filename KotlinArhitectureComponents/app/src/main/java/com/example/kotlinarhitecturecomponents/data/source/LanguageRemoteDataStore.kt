package com.example.kotlinarhitecturecomponents.data.source

import com.example.kotlinarhitecturecomponents.data.model.LanguageEntity
import com.example.kotlinarhitecturecomponents.data.repository.LanguageDataStore
import com.example.kotlinarhitecturecomponents.data.repository.LanguageRemote
import io.reactivex.Observable
import io.reactivex.Single


class LanguageRemoteDataStore (private val languageRemote: LanguageRemote) : LanguageDataStore {

    override fun getAllLanguage(i:Int,k:Int): Single<List<LanguageEntity>> {
        return languageRemote.getAllPosts(i,k)
    }

    override suspend fun storeLanguage(store: String) {
        throw UnsupportedOperationException()
    }

    override suspend fun updateLanguageName(position: Int, language: String) {
        throw UnsupportedOperationException()
    }

    override suspend fun deleteLanguageID(position: Int) {
        throw UnsupportedOperationException()
    }

    override suspend fun insertAll(list: List<LanguageEntity>) {
        throw UnsupportedOperationException()
    }

}