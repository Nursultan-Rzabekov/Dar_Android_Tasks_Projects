package com.example.cleanarhitecturewithmvvm.data.repository

import com.example.cleanarhitecturewithmvvm.data.model.LanguageEntity


interface LanguageRoom {

    suspend fun getAllLanguage() : List<LanguageEntity>

    suspend fun storeLanguage(store:String)

    suspend fun updateLanguageName(position: Int, language: String)

    suspend fun deleteLanguageID(position: Int)

    suspend fun getByLanguageID(position: Int): String?

    suspend fun storeAllLanguage(languageList:List<LanguageEntity>?)

    suspend fun deleteAllLanguageById()

    suspend fun isCached(): Boolean

}