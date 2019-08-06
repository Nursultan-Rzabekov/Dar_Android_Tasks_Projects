package com.example.cleanarhitecturewithmvvm.data.repository


import com.example.cleanarhitecturewithmvvm.data.model.LanguageEntity


interface LanguageRemote {

    suspend fun getAllPosts(): List<LanguageEntity>
}