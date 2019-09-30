package com.example.kotlinarhitecturecomponents.domain.usecase.delete


import com.example.kotlinarhitecturecomponents.domain.repository.IRoomRepository
import com.example.kotlinarhitecturecomponents.domain.type.delete.DeleteByIdUseCase


class DeleteLanguageUseCase(private val iRoomRepository: IRoomRepository) : DeleteByIdUseCase<Int> {
    override suspend fun execute(position: Int) {
        iRoomRepository.deleteLanguageID(position)
    }
}