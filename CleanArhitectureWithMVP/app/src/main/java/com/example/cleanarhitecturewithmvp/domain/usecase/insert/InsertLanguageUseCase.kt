package com.example.cleanarhitecturewithmvp.domain.usecase.insert

import com.example.cleanarhitecturewithmvp.domain.repository.IRoomRepository
import com.example.cleanarhitecturewithmvp.domain.type.insert.InsertUseCase

class InsertLanguageUseCase(private val iRoomRepository: IRoomRepository) : InsertUseCase<String> {
    override suspend fun execute(store: String) {
        iRoomRepository.storeLanguage(store)
    }
}