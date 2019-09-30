package com.example.kotlinarhitecturecomponents.domain.type.delete


interface DeleteByIdUseCase<P> {
    suspend fun execute(position: P)
}