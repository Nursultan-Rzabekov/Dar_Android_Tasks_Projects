package com.example.cleanarhitecturewithmvp.domain.usecase.get

import com.example.cleanarhitecturewithmvp.domain.model.Language
import com.example.cleanarhitecturewithmvp.domain.repository.IRoomRepository

import com.example.cleanarhitecturewithmvp.domain.type.get.GetAllUseCase

class GetLanguageUseCase(private val iRoomRepository: IRoomRepository) : GetAllUseCase<Language> {

    override suspend fun execute(): List<Language> {
        return iRoomRepository.getAllLanguage()
    }

}