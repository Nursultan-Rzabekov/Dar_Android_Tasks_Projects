package com.example.maybecleanarhitecturewithmvp.domain.usecase.get

import com.example.maybecleanarhitecturewithmvp.domain.model.Language
import com.example.maybecleanarhitecturewithmvp.domain.repository.IRoomRepository

import com.example.maybecleanarhitecturewithmvp.domain.type.get.GetAllUseCase

class GetLanguageUseCase(private val iRoomRepository: IRoomRepository) : GetAllUseCase<Language> {

    override suspend fun execute(): List<Language> {
        return iRoomRepository.getAllLanguage()
    }

}