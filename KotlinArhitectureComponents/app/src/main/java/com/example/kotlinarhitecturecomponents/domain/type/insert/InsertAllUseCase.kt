package com.example.kotlinarhitecturecomponents.domain.type.insert


interface InsertAllUseCase<T> {
    suspend fun execute(languageList:List<T>?)
}