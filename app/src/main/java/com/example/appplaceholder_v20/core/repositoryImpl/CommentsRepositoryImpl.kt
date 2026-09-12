package com.example.appplaceholder_v20.core.repositoryImpl

import com.example.appplaceholder_v20.core.datasource.DataSorce
import com.example.appplaceholder_v20.core.mappers.toDomain
import com.example.appplaceholder_v20.modulos.comment.domain.model.DatosComments
import com.example.appplaceholder_v20.modulos.comment.domain.repository.CommentsRepository
import javax.inject.Inject

class CommentsRepositoryImpl@Inject constructor(
    val dataSource: DataSorce
): CommentsRepository {
    override suspend fun getListaComments(): List<DatosComments> {
        val listaDto = dataSource.getDatosComments()
        return listaDto.map { dto ->
            dto.toDomain()
        }
    }
}