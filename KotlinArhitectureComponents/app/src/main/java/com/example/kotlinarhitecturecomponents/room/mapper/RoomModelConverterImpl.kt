package com.example.kotlinarhitecturecomponents.room.mapper


import com.example.kotlinarhitecturecomponents.data.model.LanguageEntity
import com.example.kotlinarhitecturecomponents.room.model.LanguageRoomDB


class RoomModelConverterImpl : RoomModelConverter {


    override fun modelToDomain(languageRoomDB: LanguageRoomDB): LanguageEntity {
        return LanguageEntity(
            languageRoomDB.id,
            languageRoomDB.languageName,
            languageRoomDB.created_at,
            languageRoomDB.updated_at
        )
    }


    override fun apiToModel(languageEntity: LanguageEntity): LanguageRoomDB {
        return LanguageRoomDB(
            languageEntity.id,
            languageEntity.languageName
        )
    }
}