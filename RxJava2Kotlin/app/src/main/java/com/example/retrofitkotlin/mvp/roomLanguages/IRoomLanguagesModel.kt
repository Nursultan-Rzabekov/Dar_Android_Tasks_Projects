package com.example.retrofitkotlin.mvp.roomLanguages

import com.example.retrofitkotlin.data.LanguageRoomDB
import io.reactivex.Completable
import io.reactivex.Flowable


interface IRoomLanguagesModel {
    fun getAllLanguage() : Flowable<List<LanguageRoomDB>>
    fun storeLanguage(store:String) : Completable
    fun updateLanguageName(position: Int, language: String): Completable
    fun deleteLanguage(position: Int)
    fun deleteLanguageID(position: Int)
    fun getByLanguageID(position: Int): Flowable<String>
    fun storeAllLanguage(languagelist:List<LanguageRoomDB>):Completable
}