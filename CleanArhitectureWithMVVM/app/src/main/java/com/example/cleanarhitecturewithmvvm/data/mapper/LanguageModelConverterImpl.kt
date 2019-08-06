package com.example.cleanarhitecturewithmvvm.data.mapper

import com.example.cleanarhitecturewithmvvm.data.model.LanguageEntity
import com.example.cleanarhitecturewithmvvm.domain.model.Language

class LanguageModelConverterImpl : LanguageModelConverter {


    override fun modelToDomain(languageEntity: LanguageEntity): Language {
        return Language(
            languageEntity.id,
            languageEntity.languageName,
            languageEntity.created_at,
            languageEntity.updated_at
        )
    }


    override fun apiToModel(language: Language): LanguageEntity {
        return LanguageEntity(
            language.id,
            language.languageName,
            language.created_at,
            language.updated_at
        )
    }
}