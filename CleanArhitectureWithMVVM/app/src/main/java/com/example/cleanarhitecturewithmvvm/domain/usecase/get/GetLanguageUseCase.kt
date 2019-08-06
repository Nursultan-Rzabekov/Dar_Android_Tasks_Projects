package com.example.cleanarhitecturewithmvvm.domain.usecase.get

import com.example.cleanarhitecturewithmvvm.domain.model.Language
import com.example.cleanarhitecturewithmvvm.domain.repository.IRoomRepository

import com.example.cleanarhitecturewithmvvm.domain.type.get.GetAllUseCase

class GetLanguageUseCase(private val iRoomRepository: IRoomRepository) : GetAllUseCase<Language> {

    override suspend fun execute(): List<Language> {
        return iRoomRepository.getAllLanguage()
    }

}