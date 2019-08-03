package com.example.cleanarhitecturewithmvp.domain.type.update



interface UpdateUseCase<P,T> {
    suspend fun execute(position: P , language_name: T)
}