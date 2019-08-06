package com.example.cleanarhitecturewithmvvm.domain.usecase.insert

import com.example.cleanarhitecturewithmvvm.domain.repository.IRoomRepository
import com.example.cleanarhitecturewithmvvm.domain.type.insert.InsertUseCase

class InsertLanguageUseCase(private val iRoomRepository: IRoomRepository) : InsertUseCase<String> {
    override suspend fun execute(store: String) {
        iRoomRepository.storeLanguage(store)
    }
}