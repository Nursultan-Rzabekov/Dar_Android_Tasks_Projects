package com.example.cleanarhitecturewithmvvm.domain.type.get

interface GetAllUseCase<T> {
    suspend fun execute() : List<T>
}