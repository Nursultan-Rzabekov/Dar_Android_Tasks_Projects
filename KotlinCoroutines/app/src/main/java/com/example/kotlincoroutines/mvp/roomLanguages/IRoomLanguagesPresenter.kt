package com.example.kotlincoroutines.mvp.roomLanguages

import com.example.kotlincoroutines.data.LanguageRoomDB
import kotlinx.coroutines.Job


interface IRoomLanguagesPresenter {
    fun getAllLanguage(): Job
    fun storeLanguage(store:String)
    fun updateLanguageName(position: Int,language_name: String)
    suspend fun storeLanguageAll(languageList: ArrayList<LanguageRoomDB>?)
    fun deleteAllLanguage()
    suspend fun getByLanguageID(position: Int)
    fun deleteLanguageByID(position: Int)
}