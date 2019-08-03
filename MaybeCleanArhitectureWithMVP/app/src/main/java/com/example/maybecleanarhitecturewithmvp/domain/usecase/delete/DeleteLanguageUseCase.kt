package com.example.maybecleanarhitecturewithmvp.domain.usecase.delete

import com.example.maybecleanarhitecturewithmvp.domain.model.Language
import com.example.maybecleanarhitecturewithmvp.domain.repository.IRoomRepository
import com.example.maybecleanarhitecturewithmvp.domain.type.delete.DeleteByIdUseCase
import com.example.maybecleanarhitecturewithmvp.domain.type.insert.InsertAllUseCase

class DeleteLanguageUseCase(private val iRoomRepository: IRoomRepository) : DeleteByIdUseCase<Int> {
    override suspend fun execute(position: Int) {
        iRoomRepository.deleteLanguageID(position)
    }
}