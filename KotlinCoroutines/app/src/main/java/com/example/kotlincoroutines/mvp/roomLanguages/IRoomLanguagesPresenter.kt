package com.example.kotlincoroutines.mvp.roomLanguages

import com.example.kotlincoroutines.data.LanguageRoomDB



interface IRoomLanguagesPresenter {
    suspend fun getAllLanguage()
    fun storeLanguage(store:String)
    fun updateLanguageName(position: Int,language_name: String)
    suspend fun storeLanguageAll(languageList: ArrayList<LanguageRoomDB>?)
    fun deleteAllLanguage()
    suspend fun getByLanguageID(position: Int)
    fun deleteLanguageByID(position: Int)
}