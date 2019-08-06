package com.example.cleanarhitecturewithmvvm.domain.type.delete


interface DeleteByIdUseCase<P> {
    suspend fun execute(position: P)
}