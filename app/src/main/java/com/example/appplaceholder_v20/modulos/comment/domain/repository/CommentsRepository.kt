package com.example.appplaceholder_v20.modulos.comment.domain.repository

import com.example.appplaceholder_v20.modulos.comment.domain.model.DatosComments
import javax.inject.Inject

interface CommentsRepository {

    suspend fun getListaComments(): List<DatosComments>

}