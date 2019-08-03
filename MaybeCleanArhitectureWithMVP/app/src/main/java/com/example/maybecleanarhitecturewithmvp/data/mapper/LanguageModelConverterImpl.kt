package com.example.maybecleanarhitecturewithmvp.data.mapper

import com.example.maybecleanarhitecturewithmvp.data.model.LanguageRoomDB
import com.example.maybecleanarhitecturewithmvp.domain.model.Language

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