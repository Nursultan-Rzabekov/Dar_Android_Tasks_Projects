package com.example.cleanarhitecturewithmvvm.data.repository

import com.example.cleanarhitecturewithmvvm.data.model.LanguageEntity
import io.reactivex.Observable


interface LanguageDataStore {

    suspend fun getAllLanguage() : List<LanguageEntity>

    suspend fun storeLanguage(store:String)

    suspend fun updateLanguageName(position: Int, language: String)

    suspend fun deleteLanguageID(position: Int)

    suspend fun insertAll(list: List<LanguageEntity>)
}