package com.example.cleanarhitecturewithmvp.domain.type.get

interface GetAllUseCase<T> {
    suspend fun execute() : List<T>
}