package com.example.cleanarhitecturewithmvvm.remote.mapper

import com.example.cleanarhitecturewithmvvm.data.model.LanguageEntity
import com.example.cleanarhitecturewithmvvm.remote.model.LanguageRemoteModel


class RemoteEntityMapper : EntityMapper<LanguageRemoteModel, LanguageEntity> {

    override fun mapFromRemote(languageRemoteModel: LanguageRemoteModel): LanguageEntity {
        return LanguageEntity(languageRemoteModel.id, languageRemoteModel.languageName,languageRemoteModel.created_at,languageRemoteModel.updated_at)
    }
}