package com.example.maybecleanarhitecturewithmvp.domain.usecase.insert

import com.example.maybecleanarhitecturewithmvp.domain.model.Language
import com.example.maybecleanarhitecturewithmvp.domain.repository.IRoomRepository

import com.example.maybecleanarhitecturewithmvp.domain.type.get.GetAllUseCase
import com.example.maybecleanarhitecturewithmvp.domain.type.insert.InsertUseCase

class InsertLanguageUseCase(private val iRoomRepository: IRoomRepository) : InsertUseCase<String> {
    override suspend fun execute(store: String) {
        iRoomRepository.storeLanguage(store)
    }
}