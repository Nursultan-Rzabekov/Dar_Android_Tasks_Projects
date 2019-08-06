package com.example.cleanarhitecturewithmvvm.data.source

import com.example.cleanarhitecturewithmvvm.data.model.LanguageEntity
import com.example.cleanarhitecturewithmvvm.data.repository.LanguageDataStore
import com.example.cleanarhitecturewithmvvm.data.repository.LanguageRemote
import io.reactivex.Observable


class LanguageRemoteDataStore (private val languageRemote: LanguageRemote) : LanguageDataStore {

    override suspend fun getAllLanguage(): List<LanguageEntity> {
        return languageRemote.getAllPosts()
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