package com.example.kotlinarhitecturecomponents.room.mapper

import com.example.kotlinarhitecturecomponents.data.model.LanguageEntity
import com.example.kotlinarhitecturecomponents.room.model.LanguageRoomDB
import com.example.kotlinarhitecturecomponents.domain.model.Language

interface RoomModelConverter {

    fun modelToDomain(languageRoomDB: LanguageRoomDB):LanguageEntity

    fun apiToModel(languageEntity: LanguageEntity): LanguageRoomDB
}