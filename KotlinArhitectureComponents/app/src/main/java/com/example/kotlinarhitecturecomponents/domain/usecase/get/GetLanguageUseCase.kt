package com.example.kotlinarhitecturecomponents.domain.usecase.get

import com.example.kotlinarhitecturecomponents.domain.model.Language
import com.example.kotlinarhitecturecomponents.domain.repository.IRoomRepository

import com.example.kotlinarhitecturecomponents.domain.type.get.GetAllUseCase

class GetLanguageUseCase(private val iRoomRepository: IRoomRepository) : GetAllUseCase<Language> {

    override suspend fun execute(): List<Language> {
        return iRoomRepository.getAllLanguage()
    }

}