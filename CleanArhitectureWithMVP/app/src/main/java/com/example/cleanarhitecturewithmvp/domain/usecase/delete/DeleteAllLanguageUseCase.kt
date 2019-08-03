package com.example.cleanarhitecturewithmvp.domain.usecase.delete


import com.example.cleanarhitecturewithmvp.domain.repository.IRoomRepository
import com.example.cleanarhitecturewithmvp.domain.type.delete.DeleteAllUseCase


class DeleteAllLanguageUseCase(private val iRoomRepository: IRoomRepository) : DeleteAllUseCase {
    override suspend fun execute() {
        iRoomRepository.deleteAllLanguageById()
    }
}