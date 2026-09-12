package com.example.appplaceholder_v20.core.datasource

import com.example.appplaceholder_v20.core.model.DatosCommentsDto
import com.example.appplaceholder_v20.core.model.DatosTodosDto
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    // 🌟 Endpoint oficial de Loterías API para los últimos resultados de la Primitiva
    @GET("posts/1/comments")
    suspend fun getListaComments(): Response<List<DatosCommentsDto>>

    @GET("post/1/todos")
    suspend fun getListaTodos(): Response<List<DatosTodosDto>>
}