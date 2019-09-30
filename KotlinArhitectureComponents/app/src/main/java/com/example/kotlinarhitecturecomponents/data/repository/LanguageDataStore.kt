package com.example.kotlinarhitecturecomponents.data.repository

import com.example.kotlinarhitecturecomponents.data.model.LanguageEntity
import io.reactivex.Observable
import io.reactivex.Single


interface LanguageDataStore {

    fun getAllLanguage(i:Int,k:Int) : Single<List<LanguageEntity>>

    suspend fun storeLanguage(store:String)

    suspend fun updateLanguageName(position: Int, language: String)

    suspend fun deleteLanguageID(position: Int)

    suspend fun insertAll(list: List<LanguageEntity>)
}