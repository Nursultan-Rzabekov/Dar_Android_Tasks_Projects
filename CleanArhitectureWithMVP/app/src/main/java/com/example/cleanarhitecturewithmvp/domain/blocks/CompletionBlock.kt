package com.example.cleanarhitecturewithmvp.domain.blocks

import com.example.cleanarhitecturewithmvp.domain.BaseCoroutinesUseCase


typealias CompletionBlock<T> = BaseCoroutinesUseCase.Request<T>.() -> Unit