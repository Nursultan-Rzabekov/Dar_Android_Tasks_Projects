package com.example.kotlinarhitecturecomponents.remote.mapper


interface EntityMapper<in M, out E> {

    fun mapFromRemote(type: M): E

}