package com.example.kotlinarhitecturecomponents.domain.type.insert

interface InsertUseCase<P> {
    suspend fun execute(store:P)
}