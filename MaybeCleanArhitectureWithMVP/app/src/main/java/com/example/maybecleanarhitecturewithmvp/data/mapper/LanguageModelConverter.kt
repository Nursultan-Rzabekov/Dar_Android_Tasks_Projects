package com.example.maybecleanarhitecturewithmvp.data.mapper

import com.example.maybecleanarhitecturewithmvp.data.model.LanguageRoomDB
import com.example.maybecleanarhitecturewithmvp.domain.model.Language

interface LanguageModelConverter {

    fun modelToDomain(languageRoomDB: LanguageRoomDB):Language

    fun apiToModel(language: Language):LanguageRoomDB
}