package com.example.cleanarhitecturewithmvp.domain.blocks

import com.example.cleanarhitecturewithmvp.domain.BaseObserveCoroutinesUseCase


typealias ObserverBlock<T> = BaseObserveCoroutinesUseCase.Request<T>.() -> Unit