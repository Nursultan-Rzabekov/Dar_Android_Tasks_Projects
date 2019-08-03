package com.example.maybecleanarhitecturewithmvp.domain.type.get

interface GetAllUseCase<T> {
    suspend fun execute() : List<T>
}