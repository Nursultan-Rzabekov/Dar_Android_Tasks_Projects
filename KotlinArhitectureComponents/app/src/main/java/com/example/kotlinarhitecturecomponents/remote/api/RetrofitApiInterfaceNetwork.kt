package com.example.kotlinarhitecturecomponents.remote.api


import com.example.kotlinarhitecturecomponents.remote.model.LanguageRemoteModel
import io.reactivex.Single
import retrofit2.http.*

interface RetrofitApiInterfaceNetwork {

    @GET(ApiSettingsConstValue.GET_LANGUAGES)
    fun getAllLanguage(@Query("page") page: Int, @Query("pageSize") pageSize: Int): Single<List<LanguageRemoteModel>>

    //suspend fun getAllLanguage() : List<LanguageRemoteModel>



//    @POST(ApiSettingsConstValue.STORE_LANGUAGE)
//    suspend fun storeLanguage(@Body languageDataModel: LanguageRemoteModel): LanguageRemoteModel

//    @DELETE(ApiSettingsConstValue.DELETE_LANGUAGE+"/{id}")
//    suspend fun deleteLanguage(@Path("id") id: Int) : LanguageRemoteModel
//
//    @PUT(ApiSettingsConstValue.UPDATE_LANGUAGE+"/{id}")
//    suspend fun updateLanguage(@Path("id") id: Int, @Body languageDataModel: LanguageRemoteModel): LanguageRemoteModel

}

