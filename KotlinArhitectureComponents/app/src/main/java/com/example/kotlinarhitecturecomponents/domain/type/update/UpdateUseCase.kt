package com.example.kotlinarhitecturecomponents.domain.type.update



interface UpdateUseCase<P,T> {
    suspend fun execute(position: P , language_name: T)
}