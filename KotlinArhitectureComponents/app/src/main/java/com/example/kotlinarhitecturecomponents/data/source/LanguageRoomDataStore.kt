package com.example.kotlinarhitecturecomponents.data.source

import com.example.kotlinarhitecturecomponents.data.model.LanguageEntity
import com.example.kotlinarhitecturecomponents.data.repository.LanguageDataStore
import com.example.kotlinarhitecturecomponents.data.repository.LanguageRoom
import io.reactivex.Observable


class LanguageRoomDataStore (private val languageRoom: LanguageRoom) : LanguageDataStore {

    override suspend fun getAllLanguage(): List<LanguageEntity> {
        return languageRoom.getAllLanguage()
    }

    override suspend fun storeLanguage(store: String) {
        return languageRoom.storeLanguage(store)
    }

    override suspend fun updateLanguageName(position: Int, language: String) {
        return languageRoom.updateLanguageName(position,language)
    }

    override suspend fun deleteLanguageID(position: Int) {
        return languageRoom.deleteLanguageID(position)
    }

    override suspend fun insertAll(list: List<LanguageEntity>) {
        return languageRoom.storeAllLanguage(list)
    }

}