package com.example.cleanarhitecturewithmvp.domain.usecase.insert

import com.example.cleanarhitecturewithmvp.domain.model.Language
import com.example.cleanarhitecturewithmvp.domain.repository.IRoomRepository
import com.example.cleanarhitecturewithmvp.domain.type.insert.InsertAllUseCase

class InsertAllLanguageUseCase(private val iRoomRepository: IRoomRepository) : InsertAllUseCase<Language> {
    override suspend fun execute(languageList: List<Language>?) {
        iRoomRepository.storeAllLanguage(languageList)
    }
}