package com.example.kotlinarhitecturecomponents.domain.usecase.insert

import com.example.kotlinarhitecturecomponents.domain.repository.IRoomRepository
import com.example.kotlinarhitecturecomponents.domain.type.insert.InsertUseCase

class InsertLanguageUseCase(private val iRoomRepository: IRoomRepository) : InsertUseCase<String> {
    override suspend fun execute(store: String) {
        iRoomRepository.storeLanguage(store)
    }
}