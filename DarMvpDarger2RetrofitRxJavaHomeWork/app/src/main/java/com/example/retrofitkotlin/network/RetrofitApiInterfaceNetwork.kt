package com.example.retrofitkotlin.network

import com.example.retrofitkotlin.data.LanguageModel
import com.example.retrofitkotlin.data.LanguageModelStore
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*
import okhttp3.ResponseBody
import retrofit2.http.PUT




interface RetrofitApiInterfaceNetwork {

    @GET(ApiSettingsConstValue.GET_LANGUAGES)
    fun getallLanguage() : Observable<List<LanguageModel>>


    @POST(ApiSettingsConstValue.STORE_LANGUAGE)
    fun storelanguage(@Body languageStore:LanguageModelStore): Call<LanguageModel>


    @DELETE(ApiSettingsConstValue.DELETE_LANGUAGE+"/{id}")
    fun deleteLanguage(@Path("id") id: Int) : Call<LanguageModel>


    @PUT(ApiSettingsConstValue.UPDATE_LANGUAGE+"/{id}")
    fun updateLanguage(@Path("id") id: Int, @Body languageStore: LanguageModelStore): Call<LanguageModel>


}

