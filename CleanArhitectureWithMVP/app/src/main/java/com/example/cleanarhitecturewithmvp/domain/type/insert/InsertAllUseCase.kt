package com.example.cleanarhitecturewithmvp.domain.type.insert


interface InsertAllUseCase<T> {
    suspend fun execute(languageList:List<T>?)
}