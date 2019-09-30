package com.example.cleanarhitecturewithmvp.mvp.roomLanguages

import com.example.cleanarhitecturewithmvp.domain.model.Language
import com.example.cleanarhitecturewithmvp.mvp.IView

interface IRoomLanguagesView: IView {
    fun showAllLanguage(languagesList: List<Language>)
    fun storeLanguage(roomDB: Language)
    fun deleteLanguage()
    fun deleteLanguageByLanguageID(position: Int)
    fun updateLanguage(position: Int, languageData: Language)
}