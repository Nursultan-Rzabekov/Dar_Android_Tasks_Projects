package com.example.cleanarhitecturewithmvp.domain.type.get



interface GetbyIdUseCase<T> {
    suspend fun execute(position: Int) : T
}