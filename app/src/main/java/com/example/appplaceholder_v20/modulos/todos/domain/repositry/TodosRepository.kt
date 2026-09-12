package com.example.appplaceholder_v20.modulos.todos.domain.repositry

import com.example.appplaceholder_v20.modulos.todos.domain.model.DatosTodos
import javax.inject.Inject

interface TodosRepository {
    suspend fun getListaTodos(): List<DatosTodos>
}