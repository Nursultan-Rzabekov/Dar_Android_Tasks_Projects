package com.example.cleanarhitecturewithmvvm.domain.usecase.insert

import com.example.cleanarhitecturewithmvvm.domain.model.Language
import com.example.cleanarhitecturewithmvvm.domain.repository.IRoomRepository
import com.example.cleanarhitecturewithmvvm.domain.type.insert.InsertAllUseCase

class InsertAllLanguageUseCase(private val iRoomRepository: IRoomRepository) : InsertAllUseCase<Language> {
    override suspend fun execute(languageList: List<Language>?) {
        iRoomRepository.storeAllLanguage(languageList)
    }
}