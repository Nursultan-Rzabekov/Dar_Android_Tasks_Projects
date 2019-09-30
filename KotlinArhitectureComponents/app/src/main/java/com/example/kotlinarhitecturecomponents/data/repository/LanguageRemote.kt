package com.example.kotlinarhitecturecomponents.data.repository


import com.example.kotlinarhitecturecomponents.data.model.LanguageEntity
import io.reactivex.Single


interface LanguageRemote {

    fun getAllPosts(i:Int,k:Int): Single<List<LanguageEntity>>
}