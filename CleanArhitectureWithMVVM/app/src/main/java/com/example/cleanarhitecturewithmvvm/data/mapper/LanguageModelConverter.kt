package com.example.cleanarhitecturewithmvvm.data.mapper

import com.example.cleanarhitecturewithmvvm.data.model.LanguageEntity
import com.example.cleanarhitecturewithmvvm.room.model.LanguageRoomDB
import com.example.cleanarhitecturewithmvvm.domain.model.Language

interface LanguageModelConverter {

    fun modelToDomain(languageRoomDB: LanguageEntity):Language

    fun apiToModel(language: Language): LanguageEntity
}