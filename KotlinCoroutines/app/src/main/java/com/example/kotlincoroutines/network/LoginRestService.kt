package com.example.kotlincoroutines.network

import androidx.annotation.NonNull
import com.example.kotlincoroutines.data.AccessTokenModel
import com.example.kotlincoroutines.data.AuthModel
import retrofit2.http.*

interface LoginRestService {

    @GET("user")
    suspend fun loginAccessToken(): Login

    @POST("authorizations")
    suspend fun login(@NonNull @Body authModel: AuthModel): AccessTokenModel

    @FormUrlEncoded
    @POST("access_token")
    @Headers("Accept: application/json")
    suspend fun getAccessToken(
        @NonNull @Field("code") code: String,
        @NonNull @Field("client_id") clientId: String,
        @NonNull @Field("client_secret") clientSecret: String,
        @NonNull @Field("state") state: String,
        @NonNull @Field("redirect_uri") redirectUrl: String
    ): AccessTokenModel
}