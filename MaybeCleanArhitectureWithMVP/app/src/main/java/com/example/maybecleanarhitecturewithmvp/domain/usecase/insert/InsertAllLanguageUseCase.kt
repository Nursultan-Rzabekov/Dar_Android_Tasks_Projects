package com.example.maybecleanarhitecturewithmvp.domain.usecase.insert

import com.example.maybecleanarhitecturewithmvp.domain.model.Language
import com.example.maybecleanarhitecturewithmvp.domain.repository.IRoomRepository
import com.example.maybecleanarhitecturewithmvp.domain.type.insert.InsertAllUseCase

class InsertAllLanguageUseCase(private val iRoomRepository: IRoomRepository) : InsertAllUseCase<Language> {
    override suspend fun execute(languageList: List<Language>?) {
        iRoomRepository.storeAllLanguage(languageList)
    }
}