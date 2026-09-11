package com.example.appplaceholder_v20.modulos.comment.domain.usecase

import com.example.appplaceholder_v20.modulos.comment.domain.model.DatosComments
import javax.inject.Inject

class CommentsUseCase @Inject constructor() {

    suspend fun getListaCommentsUseCase(): List<DatosComments>{

        return emptyList()
    }
}