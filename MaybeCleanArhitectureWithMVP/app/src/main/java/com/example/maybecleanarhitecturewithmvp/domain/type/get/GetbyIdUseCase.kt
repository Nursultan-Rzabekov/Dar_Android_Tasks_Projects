package com.example.maybecleanarhitecturewithmvp.domain.type.get



interface GetbyIdUseCase<T> {
    suspend fun execute(position: Int) : T
}