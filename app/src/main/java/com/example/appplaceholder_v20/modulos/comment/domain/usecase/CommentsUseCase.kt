package com.example.appplaceholder_v20.modulos.comment.domain.usecase

import com.example.appplaceholder_v20.modulos.comment.domain.model.DatosComments
import com.example.appplaceholder_v20.modulos.comment.domain.repository.CommentsRepository
import javax.inject.Inject

class CommentsUseCase @Inject constructor(
    val repository: CommentsRepository
) {

    suspend fun getListaCommentsUseCase(): List<DatosComments>{
        return repository.getListaComments()
    }
}