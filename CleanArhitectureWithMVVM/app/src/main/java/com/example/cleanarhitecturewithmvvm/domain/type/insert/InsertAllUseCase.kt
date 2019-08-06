package com.example.cleanarhitecturewithmvvm.domain.type.insert


interface InsertAllUseCase<T> {
    suspend fun execute(languageList:List<T>?)
}