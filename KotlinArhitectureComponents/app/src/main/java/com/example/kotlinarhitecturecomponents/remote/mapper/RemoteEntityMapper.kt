package com.example.kotlinarhitecturecomponents.remote.mapper

import com.example.kotlinarhitecturecomponents.data.model.LanguageEntity
import com.example.kotlinarhitecturecomponents.remote.model.LanguageRemoteModel


class RemoteEntityMapper : EntityMapper<LanguageRemoteModel, LanguageEntity> {

    override fun mapFromRemote(languageRemoteModel: LanguageRemoteModel): LanguageEntity {
        return LanguageEntity(languageRemoteModel.id, languageRemoteModel.languageName,languageRemoteModel.created_at,languageRemoteModel.updated_at)
    }
}