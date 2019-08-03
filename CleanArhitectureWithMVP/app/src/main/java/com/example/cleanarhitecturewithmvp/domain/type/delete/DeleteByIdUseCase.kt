package com.example.cleanarhitecturewithmvp.domain.type.delete


interface DeleteByIdUseCase<P> {
    suspend fun execute(position: P)
}