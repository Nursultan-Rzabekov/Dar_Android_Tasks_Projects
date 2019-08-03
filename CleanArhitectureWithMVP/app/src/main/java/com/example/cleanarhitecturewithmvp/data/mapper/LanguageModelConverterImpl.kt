package com.example.cleanarhitecturewithmvp.data.mapper

import com.example.cleanarhitecturewithmvp.data.model.LanguageRoomDB
import com.example.cleanarhitecturewithmvp.domain.model.Language

class LanguageModelConverterImpl : LanguageModelConverter {


    override fun modelToDomain(languageRoomDB: LanguageRoomDB): Language {
        return Language(
            languageRoomDB.id,
            languageRoomDB.languageName,
            languageRoomDB.created_at,
            languageRoomDB.updated_at
        )
    }


    override fun apiToModel(language: Language): LanguageRoomDB {
        return LanguageRoomDB(
            language.id,
            language.languageName
        )
    }
}