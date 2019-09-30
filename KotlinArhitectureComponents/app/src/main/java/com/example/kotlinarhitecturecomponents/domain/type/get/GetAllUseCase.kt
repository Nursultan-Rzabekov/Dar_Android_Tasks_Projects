package com.example.kotlinarhitecturecomponents.domain.type.get

interface GetAllUseCase<T> {
    suspend fun execute() : List<T>
}