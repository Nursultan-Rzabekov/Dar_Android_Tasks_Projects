package com.example.retrofitkotlin.mvp.roomLanguages

import com.example.retrofitkotlin.data.LanguageRoomDB
import com.example.retrofitkotlin.mvp.IView

interface IRoomLanguagesView: IView {
    fun showAllLanguage(languagesList: List<LanguageRoomDB>)
    fun storeLanguage(roomDB: LanguageRoomDB)
    fun deleteLanguage(position: Int)
    fun deleteLanguageByLanguageID(position: Int)
    fun updateLanguage(position: Int, languageData: LanguageRoomDB)
}