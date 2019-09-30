package com.example.cleanarhitecturewithmvp.domain.usecase.get

import com.example.cleanarhitecturewithmvp.domain.BaseCoroutinesUseCase
import com.example.cleanarhitecturewithmvp.domain.model.Language
import com.example.cleanarhitecturewithmvp.domain.repository.IRoomRepository

import com.example.cleanarhitecturewithmvp.domain.type.get.GetAllUseCase
import javax.inject.Inject

class GetLanguageUseCase @Inject constructor(private val iRoomRepository: IRoomRepository)
    : BaseCoroutinesUseCase<List<Language>>() {

    override suspend fun executeOnBackground(): List<Language> {
        return iRoomRepository.getAllLanguage()
    }
}