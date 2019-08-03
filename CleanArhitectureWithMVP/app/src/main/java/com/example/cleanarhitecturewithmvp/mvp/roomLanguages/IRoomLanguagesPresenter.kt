package com.example.cleanarhitecturewithmvp.mvp.roomLanguages


import com.example.cleanarhitecturewithmvp.domain.model.Language
import kotlinx.coroutines.Job


interface IRoomLanguagesPresenter {
    fun getAllLanguage(): Job
    fun storeLanguage(store:String)
    fun updateLanguageName(position: Int,language_name: String)
    fun storeLanguageAll(languageList: ArrayList<Language>?)
    fun deleteAllLanguage()
    fun getByLanguageID(position: Int)
    fun deleteLanguageByID(position: Int)
}