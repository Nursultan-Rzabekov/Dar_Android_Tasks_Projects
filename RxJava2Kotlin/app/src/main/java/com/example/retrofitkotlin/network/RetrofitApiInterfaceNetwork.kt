package com.example.retrofitkotlin.network

import com.example.retrofitkotlin.data.LanguageRoomDB
import io.reactivex.Observable
import retrofit2.http.*

interface RetrofitApiInterfaceNetwork {

    @GET(ApiSettingsConstValue.GET_LANGUAGES)
    fun getAllLanguage() : Observable<List<LanguageRoomDB>>

    @POST(ApiSettingsConstValue.STORE_LANGUAGE)
    fun storeLanguage(@Body languageData: LanguageRoomDB): Observable<LanguageRoomDB>

    @DELETE(ApiSettingsConstValue.DELETE_LANGUAGE+"/{id}")
    fun deleteLanguage(@Path("id") id: Int) : Observable<LanguageRoomDB>

    @PUT(ApiSettingsConstValue.UPDATE_LANGUAGE+"/{id}")
    fun updateLanguage(@Path("id") id: Int, @Body languageData: LanguageRoomDB): Observable<LanguageRoomDB>

}

