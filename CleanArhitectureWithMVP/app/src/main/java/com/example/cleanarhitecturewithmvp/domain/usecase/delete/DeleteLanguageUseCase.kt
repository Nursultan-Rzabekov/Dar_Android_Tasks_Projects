package com.example.cleanarhitecturewithmvp.domain.usecase.delete


import com.example.cleanarhitecturewithmvp.domain.repository.IRoomRepository
import com.example.cleanarhitecturewithmvp.domain.type.delete.DeleteByIdUseCase


class DeleteLanguageUseCase(private val iRoomRepository: IRoomRepository) : DeleteByIdUseCase<Int> {
    override suspend fun execute(position: Int) {
        iRoomRepository.deleteLanguageID(position)
    }
}