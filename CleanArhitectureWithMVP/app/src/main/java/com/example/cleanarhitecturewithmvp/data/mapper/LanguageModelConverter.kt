package com.example.cleanarhitecturewithmvp.data.mapper

import com.example.cleanarhitecturewithmvp.data.model.LanguageEntity
import com.example.cleanarhitecturewithmvp.room.model.LanguageRoomDB
import com.example.cleanarhitecturewithmvp.domain.model.Language

interface LanguageModelConverter {

    fun modelToDomain(languageRoomDB: LanguageEntity):Language

    fun apiToModel(language: Language): LanguageEntity
}