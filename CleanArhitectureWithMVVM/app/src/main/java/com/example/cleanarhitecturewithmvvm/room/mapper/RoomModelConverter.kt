package com.example.cleanarhitecturewithmvvm.room.mapper

import com.example.cleanarhitecturewithmvvm.data.model.LanguageEntity
import com.example.cleanarhitecturewithmvvm.room.model.LanguageRoomDB
import com.example.cleanarhitecturewithmvvm.domain.model.Language

interface RoomModelConverter {

    fun modelToDomain(languageRoomDB: LanguageRoomDB):LanguageEntity

    fun apiToModel(languageEntity: LanguageEntity): LanguageRoomDB
}