package com.example.maybecleanarhitecturewithmvp.domain.usecase.get

import com.example.maybecleanarhitecturewithmvp.domain.repository.IRoomRepository
import com.example.maybecleanarhitecturewithmvp.domain.type.get.GetbyIdUseCase

class GetLanguageByIdUseCase(private val iRoomRepository: IRoomRepository) : GetbyIdUseCase<String?> {

    override suspend fun execute(position: Int): String? {
        return iRoomRepository.getByLanguageID(position)
    }

}