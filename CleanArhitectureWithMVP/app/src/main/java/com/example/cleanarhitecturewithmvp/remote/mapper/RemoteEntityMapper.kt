package com.example.cleanarhitecturewithmvp.remote.mapper

import com.example.cleanarhitecturewithmvp.data.model.LanguageEntity
import com.example.cleanarhitecturewithmvp.remote.model.LanguageRemoteModel


class RemoteEntityMapper : EntityMapper<LanguageRemoteModel, LanguageEntity> {

    override fun mapFromRemote(languageRemoteModel: LanguageRemoteModel): LanguageEntity {
        return LanguageEntity(languageRemoteModel.id, languageRemoteModel.languageName,languageRemoteModel.created_at,languageRemoteModel.updated_at)
    }
}