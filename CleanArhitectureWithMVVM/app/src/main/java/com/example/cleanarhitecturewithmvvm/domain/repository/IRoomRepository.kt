package com.example.cleanarhitecturewithmvvm.domain.repository


import com.example.cleanarhitecturewithmvvm.domain.model.Language


interface IRoomRepository {

    suspend fun getAllLanguage() : List<Language>

    suspend fun storeLanguage(store:String)

    suspend fun updateLanguageName(position: Int, language: String)

    suspend fun deleteLanguageID(position: Int)

    suspend fun storeAllLanguage(languageList:List<Language>?)

}