package com.example.cleanarhitecturewithmvp.room.mapper

import com.example.cleanarhitecturewithmvp.data.model.LanguageEntity
import com.example.cleanarhitecturewithmvp.room.model.LanguageRoomDB
import com.example.cleanarhitecturewithmvp.domain.model.Language

interface RoomModelConverter {

    fun modelToDomain(languageRoomDB: LanguageRoomDB):LanguageEntity

    fun apiToModel(languageEntity: LanguageEntity): LanguageRoomDB
}