package com.example.cleanarhitecturewithmvp.domain.model

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("message") val message: String?
)