package com.example.kotlinarhitecturecomponents.data.mapper

import com.example.kotlinarhitecturecomponents.data.model.LanguageEntity
import com.example.kotlinarhitecturecomponents.room.model.LanguageRoomDB
import com.example.kotlinarhitecturecomponents.domain.model.Language

interface LanguageModelConverter {

    fun modelToDomain(languageRoomDB: LanguageEntity):Language

    fun apiToModel(language: Language): LanguageEntity
}