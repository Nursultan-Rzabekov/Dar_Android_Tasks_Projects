package com.example.cleanarhitecturewithmvp.domain.usecase.get

import com.example.cleanarhitecturewithmvp.domain.repository.IRoomRepository
import com.example.cleanarhitecturewithmvp.domain.type.get.GetbyIdUseCase

class GetLanguageByIdUseCase(private val iRoomRepository: IRoomRepository) : GetbyIdUseCase<String?> {

    override suspend fun execute(position: Int): String? {
        return iRoomRepository.getByLanguageID(position)
    }

}