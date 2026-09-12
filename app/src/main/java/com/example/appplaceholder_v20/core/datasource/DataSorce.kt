package com.example.appplaceholder_v20.core.datasource

import com.example.appplaceholder_v20.core.di.IoDispatcher
import com.example.appplaceholder_v20.core.model.DatosCommentsDto
import com.example.appplaceholder_v20.core.model.DatosTodosDto
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DataSorce @Inject constructor(
    private val apiService: ApiService,
    @IoDispatcher private val ioDispacher: CoroutineDispatcher
) {
    suspend fun getDatosComments(): List<DatosCommentsDto>{
        return withContext(ioDispacher){
            try {
                val respuesta = apiService.getListaComments()
                if(respuesta.isSuccessful && respuesta.body() != null){
                    respuesta.body()!!
                }
                else{
                    emptyList<DatosCommentsDto>()
                }
            }
            catch (e: Exception){
                emptyList<DatosCommentsDto>()
            }
        }
    }

    suspend fun getDatosTodos(): List<DatosTodosDto>{
        return withContext(ioDispacher){
            try {
                val respuesta = apiService.getListaTodos()
                if(respuesta.isSuccessful && respuesta.body() != null){
                    respuesta.body()!!
                }
                else{
                    emptyList()
                }
            }
            catch (e: Exception){
                emptyList<DatosTodosDto>()
            }
        }
    }


}