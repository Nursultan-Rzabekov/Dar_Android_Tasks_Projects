package com.example.kotlincoroutines.mvp.retrofitpresenter

import com.example.kotlincoroutines.data.LanguageRoomDB
import com.example.kotlincoroutines.mvp.IView


interface LanguagesView: IView {
    fun showAllPosts(languagesList: List<LanguageRoomDB>)
    fun storePost(languageData: LanguageRoomDB)
    fun deletePost(position: Int)
    fun updatePost(position: Int, languageData: LanguageRoomDB)
}