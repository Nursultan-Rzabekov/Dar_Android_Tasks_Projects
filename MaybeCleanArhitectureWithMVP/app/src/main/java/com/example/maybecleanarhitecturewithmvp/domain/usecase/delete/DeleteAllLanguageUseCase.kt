package com.example.maybecleanarhitecturewithmvp.domain.usecase.delete

import com.example.maybecleanarhitecturewithmvp.domain.model.Language
import com.example.maybecleanarhitecturewithmvp.domain.repository.IRoomRepository
import com.example.maybecleanarhitecturewithmvp.domain.type.delete.DeleteAllUseCase
import com.example.maybecleanarhitecturewithmvp.domain.type.insert.InsertAllUseCase

class DeleteAllLanguageUseCase(private val iRoomRepository: IRoomRepository) : DeleteAllUseCase {
    override suspend fun execute() {
        iRoomRepository.deleteAllLanguageById()
    }
}