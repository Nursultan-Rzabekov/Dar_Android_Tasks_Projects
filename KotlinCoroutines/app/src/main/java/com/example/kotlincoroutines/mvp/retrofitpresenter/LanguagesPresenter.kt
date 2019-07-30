package com.example.kotlincoroutines.mvp.retrofitpresenter

import kotlinx.coroutines.Job


interface LanguagesPresenter {
    fun getAllPosts(): Job
    fun storePosts(store:String): Job
    fun updatePosts(position: Int,store: String,db_position:Int): Job
    fun deletePosts(position: Int,db_position: Int): Job
}