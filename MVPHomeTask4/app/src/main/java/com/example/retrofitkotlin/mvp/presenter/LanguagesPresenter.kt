package com.example.retrofitkotlin.mvp.presenter


interface LanguagesPresenter {
    fun getAllPosts()
    fun storePosts(store:String)
    fun updatePosts(position: Int,store: String,db_position:Int)
    fun deletePosts(position: Int,db_position: Int)
}