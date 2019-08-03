package com.example.cleanarhitecturewithmvp.domain.repository


import com.example.cleanarhitecturewithmvp.domain.model.Language


interface IRoomRepository {


    suspend fun getAllLanguage() : List<Language>

    suspend fun storeLanguage(store:String)

    suspend fun updateLanguageName(position: Int, language: String)

    suspend fun deleteLanguageID(position: Int)

    suspend fun getByLanguageID(position: Int): String?

    suspend fun storeAllLanguage(languageList:List<Language>?)

    suspend fun deleteAllLanguageById()
}