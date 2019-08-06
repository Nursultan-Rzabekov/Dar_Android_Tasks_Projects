package com.example.cleanarhitecturewithmvvm.domain.usecase.update


import com.example.cleanarhitecturewithmvvm.domain.repository.IRoomRepository
import com.example.cleanarhitecturewithmvvm.domain.type.update.UpdateUseCase

class UpdateLanguageUseCase(private val iRoomRepository: IRoomRepository) : UpdateUseCase<Int,String> {
    override suspend fun execute(position: Int, language_name: String) {
        iRoomRepository.updateLanguageName(position,language_name)
    }
}