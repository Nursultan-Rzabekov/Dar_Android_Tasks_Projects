package com.example.maybecleanarhitecturewithmvp.domain.usecase.update


import com.example.maybecleanarhitecturewithmvp.domain.repository.IRoomRepository
import com.example.maybecleanarhitecturewithmvp.domain.type.update.UpdateUseCase

class UpdateLanguageUseCase(private val iRoomRepository: IRoomRepository) : UpdateUseCase<Int,String> {
    override suspend fun execute(position: Int, language_name: String) {
        iRoomRepository.updateLanguageName(position,language_name)
    }
}