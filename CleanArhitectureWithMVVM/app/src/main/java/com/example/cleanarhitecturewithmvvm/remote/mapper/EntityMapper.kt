package com.example.cleanarhitecturewithmvvm.remote.mapper


interface EntityMapper<in M, out E> {

    fun mapFromRemote(type: M): E

}