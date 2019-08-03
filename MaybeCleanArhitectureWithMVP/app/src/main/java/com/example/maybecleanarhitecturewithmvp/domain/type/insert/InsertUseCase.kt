package com.example.maybecleanarhitecturewithmvp.domain.type.insert

interface InsertUseCase<P> {
    suspend fun execute(store:P)
}