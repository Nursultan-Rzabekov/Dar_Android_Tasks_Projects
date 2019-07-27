package com.example.retrofitkotlin.mvp.presenter

import com.example.retrofitkotlin.data.LanguageRoomDB
import com.example.retrofitkotlin.mvp.IView

interface LanguagesView: IView {
    fun showAllPosts(languagesList: List<LanguageRoomDB>)
    fun storePost(languageData: LanguageRoomDB)
    fun deletePost(position: Int)
    fun updatePost(position: Int, languageData: LanguageRoomDB)
}