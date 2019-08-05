package com.example.cleanarhitecturewithmvp.remote.mapper


interface EntityMapper<in M, out E> {

    fun mapFromRemote(type: M): E

}