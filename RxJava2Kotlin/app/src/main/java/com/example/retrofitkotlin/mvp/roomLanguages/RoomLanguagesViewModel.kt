package com.example.retrofitkotlin.mvp.roomLanguages

import com.example.retrofitkotlin.data.LanguageRoomDB
import com.example.retrofitkotlin.roomdb.dao.LanguageDao
import io.reactivex.Completable
import io.reactivex.Flowable

class RoomLanguagesViewModel(private val dataSource: LanguageDao): IRoomLanguagesModel{

    override fun getByLanguageID(position: Int): Flowable<String> {
        return dataSource.getLanguageById(position).map { language -> language.languageName }
    }

    override fun getAllLanguage() : Flowable<List<LanguageRoomDB>>{
        return dataSource.getAllChapter()
    }

    override fun storeLanguage(language_name: String) : Completable {
        val language = LanguageRoomDB(0,language_name)
        return dataSource.insertLanguage(language)
    }

    override fun storeAllLanguage(languagelist: List<LanguageRoomDB>): Completable {
        return dataSource.insertAllLanguage(languagelist)
    }

    override fun updateLanguageName(position: Int, language_name: String) : Completable {
        val language = LanguageRoomDB(position+1, language_name)
        return dataSource.updateLanguage(language)
    }

    override fun deleteLanguageID(position: Int) {
        return dataSource.deleteLanguageByID(position+1)
    }

    override fun deleteLanguage(position: Int) {
        return dataSource.deleteAllLanguage()
    }

}