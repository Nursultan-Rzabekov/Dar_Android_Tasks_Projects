package com.example.retrofitkotlin.mvp.roomLanguages

import com.example.retrofitkotlin.data.LanguageRoomDB


interface IRoomLanguagesPresenter {
    fun getAllLanguage()
    fun storeLanguage(store:String)
    fun updateLanguageName(position: Int,language_name: String)
    fun storeLanguageAll(languageList: List<LanguageRoomDB>)
    fun deleteLanguage(position: Int)
    fun getByLanguageID()
    fun deleteLanguageByID(position: Int)
}