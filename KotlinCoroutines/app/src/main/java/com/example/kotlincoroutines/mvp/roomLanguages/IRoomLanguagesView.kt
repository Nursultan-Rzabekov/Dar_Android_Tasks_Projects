package com.example.kotlincoroutines.mvp.roomLanguages

import com.example.kotlincoroutines.data.LanguageRoomDB
import com.example.kotlincoroutines.mvp.IView


interface IRoomLanguagesView: IView {
    fun showAllLanguage(languagesList: List<LanguageRoomDB>)
    fun storeLanguage(roomDB: LanguageRoomDB)
    fun deleteLanguage()
    fun deleteLanguageByLanguageID(position: Int)
    fun updateLanguage(position: Int, languageData: LanguageRoomDB)
}