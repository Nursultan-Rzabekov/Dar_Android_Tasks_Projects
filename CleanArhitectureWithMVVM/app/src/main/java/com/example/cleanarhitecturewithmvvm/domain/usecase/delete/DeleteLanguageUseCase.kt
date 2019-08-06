package com.example.cleanarhitecturewithmvvm.domain.usecase.delete


import com.example.cleanarhitecturewithmvvm.domain.repository.IRoomRepository
import com.example.cleanarhitecturewithmvvm.domain.type.delete.DeleteByIdUseCase


class DeleteLanguageUseCase(private val iRoomRepository: IRoomRepository) : DeleteByIdUseCase<Int> {
    override suspend fun execute(position: Int) {
        iRoomRepository.deleteLanguageID(position)
    }
}