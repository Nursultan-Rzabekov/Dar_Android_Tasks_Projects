package com.example.retrofitkotlin.network


import com.example.kotlincoroutines.data.LanguageRoomDB
import kotlinx.coroutines.Deferred
import retrofit2.http.*

interface RetrofitApiInterfaceNetwork {

    @GET(ApiSettingsConstValue.GET_LANGUAGES)
    suspend fun getAllLanguage() : List<LanguageRoomDB>

    @POST(ApiSettingsConstValue.STORE_LANGUAGE)
    suspend fun storeLanguage(@Body languageData: LanguageRoomDB): LanguageRoomDB

    @DELETE(ApiSettingsConstValue.DELETE_LANGUAGE+"/{id}")
    suspend fun deleteLanguage(@Path("id") id: Int) : LanguageRoomDB

    @PUT(ApiSettingsConstValue.UPDATE_LANGUAGE+"/{id}")
    suspend fun updateLanguage(@Path("id") id: Int, @Body languageData: LanguageRoomDB): LanguageRoomDB

}

