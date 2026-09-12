package com.example.appplaceholder_v20.core.model

import com.google.gson.annotations.SerializedName

data class DatosTodosDto(
    @SerializedName("userId") val usserId: Int,
    @SerializedName("id") val Id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("completed") val completed: Boolean
)