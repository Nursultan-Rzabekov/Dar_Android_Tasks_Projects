package com.example.cleanarhitecturewithmvp.domain.usecase.update


import com.example.cleanarhitecturewithmvp.domain.repository.IRoomRepository
import com.example.cleanarhitecturewithmvp.domain.type.update.UpdateUseCase

class UpdateLanguageUseCase(private val iRoomRepository: IRoomRepository) : UpdateUseCase<Int,String> {

    override suspend fun execute(position: Int, language_name: String) {
        iRoomRepository.updateLanguageName(position,language_name)
    }
}