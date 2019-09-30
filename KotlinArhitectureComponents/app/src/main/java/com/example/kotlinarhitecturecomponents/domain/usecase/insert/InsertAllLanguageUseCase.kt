package com.example.kotlinarhitecturecomponents.domain.usecase.insert

import com.example.kotlinarhitecturecomponents.domain.model.Language
import com.example.kotlinarhitecturecomponents.domain.repository.IRoomRepository
import com.example.kotlinarhitecturecomponents.domain.type.insert.InsertAllUseCase

class InsertAllLanguageUseCase(private val iRoomRepository: IRoomRepository) : InsertAllUseCase<Language> {
    override suspend fun execute(languageList: List<Language>?) {
        iRoomRepository.storeAllLanguage(languageList)
    }
}