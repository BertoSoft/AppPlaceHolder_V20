package com.example.appplaceholder_v20.core.model

import com.google.gson.annotations.SerializedName

data class DatosDto(
    val postId: Int,
    val id: Int,
    val nombre: String,
    val eMail: String,
    val cuerpo: String
)

data class DatosCommentsDto(
    @SerializedName("postId") val postId: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val nombre: String,
    @SerializedName("email") val eMail: String,
    @SerializedName("body") val cuerpo: String,
    )
