package com.example.kotlincoroutines.mvp.roomLanguages

import com.example.kotlincoroutines.data.LanguageRoomDB

import io.reactivex.Flowable
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Job


interface IRoomRepository {
    suspend fun getAllLanguage() : List<LanguageRoomDB>
    suspend fun storeLanguage(store:String)
    suspend fun updateLanguageName(position: Int, language: String)
    suspend fun deleteLanguageID(position: Int)
    suspend fun getByLanguageID(position: Int): String?
    suspend fun storeAllLanguage(languagelist:ArrayList<LanguageRoomDB>?)
    suspend fun deleteAllLanguageById()
}