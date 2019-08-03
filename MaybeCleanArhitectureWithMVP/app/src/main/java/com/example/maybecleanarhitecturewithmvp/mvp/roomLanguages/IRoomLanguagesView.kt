package com.example.maybecleanarhitecturewithmvp.mvp.roomLanguages

import com.example.maybecleanarhitecturewithmvp.domain.model.Language
import com.example.maybecleanarhitecturewithmvp.mvp.IView


interface IRoomLanguagesView: IView {
    fun showAllLanguage(languagesList: List<Language>)
    fun storeLanguage(roomDB: Language)
    fun deleteLanguage()
    fun deleteLanguageByLanguageID(position: Int)
    fun updateLanguage(position: Int, languageData: Language)
}