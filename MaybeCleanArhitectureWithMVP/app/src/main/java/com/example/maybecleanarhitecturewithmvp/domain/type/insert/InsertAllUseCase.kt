package com.example.maybecleanarhitecturewithmvp.domain.type.insert


interface InsertAllUseCase<T> {
    suspend fun execute(languageList:List<T>?)
}