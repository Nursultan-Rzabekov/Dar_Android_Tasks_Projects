package com.example.kotlincoroutines.mvp.roomLanguages

import com.example.kotlincoroutines.data.LanguageRoomDB

import io.reactivex.Flowable
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Job


interface IRoomRepository {
    suspend fun getAllLanguage() : List<LanguageRoomDB>
    fun storeLanguage(store:String): Job
    fun updateLanguageName(position: Int, language: String): Job
    fun deleteLanguageID(position: Int): Job
    suspend fun getByLanguageID(position: Int): String?
    fun storeAllLanguage(languagelist:ArrayList<LanguageRoomDB>?): Job
    fun deleteAllLanguageById(): Job
}