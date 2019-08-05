package com.example.cleanarhitecturewithmvp.data.repository


import com.example.cleanarhitecturewithmvp.data.model.LanguageEntity


interface LanguageRemote {

    suspend fun getAllPosts(): List<LanguageEntity>
}