package com.example.cleanarhitecturewithmvp.domain.type.insert

interface InsertUseCase<P> {
    suspend fun execute(store:P)
}