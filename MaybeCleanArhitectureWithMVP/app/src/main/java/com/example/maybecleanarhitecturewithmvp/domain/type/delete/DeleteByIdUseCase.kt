package com.example.maybecleanarhitecturewithmvp.domain.type.delete


interface DeleteByIdUseCase<P> {
    suspend fun execute(position: P)
}