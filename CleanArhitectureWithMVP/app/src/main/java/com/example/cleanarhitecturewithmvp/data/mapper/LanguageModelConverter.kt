package com.example.cleanarhitecturewithmvp.data.mapper

import com.example.cleanarhitecturewithmvp.data.model.LanguageRoomDB
import com.example.cleanarhitecturewithmvp.domain.model.Language

interface LanguageModelConverter {

    fun modelToDomain(languageRoomDB: LanguageRoomDB):Language

    fun apiToModel(language: Language):LanguageRoomDB
}