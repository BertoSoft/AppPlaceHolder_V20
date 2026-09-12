package com.example.appplaceholder_v20.core.repositoryImpl

import com.example.appplaceholder_v20.core.datasource.DataSorce
import com.example.appplaceholder_v20.core.mappers.toDomain
import com.example.appplaceholder_v20.modulos.todos.domain.model.DatosTodos
import com.example.appplaceholder_v20.modulos.todos.domain.repositry.TodosRepository
import javax.inject.Inject

class TodosRepositoryImpl@Inject constructor(
    private val dataSource: DataSorce
): TodosRepository {
    override suspend fun getListaTodos(): List<DatosTodos> {
        val listaTodosDto = dataSource.getDatosTodos()
        return listaTodosDto.map { datoDto ->
            datoDto.toDomain()
        }
    }
}