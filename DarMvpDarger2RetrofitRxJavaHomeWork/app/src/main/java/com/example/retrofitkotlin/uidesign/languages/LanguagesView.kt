package com.example.retrofitkotlin.uidesign.languages

import com.example.retrofitkotlin.data.LanguageModel
import com.example.retrofitkotlin.uidesign.IView

interface LanguagesView: IView {
    fun showAllPosts(languagesList: List<LanguageModel>)
}