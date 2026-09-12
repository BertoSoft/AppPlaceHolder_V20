package com.example.appplaceholder_v20.modulos.todos.domain.usecase

import com.example.appplaceholder_v20.modulos.todos.domain.model.DatosTodos
import com.example.appplaceholder_v20.modulos.todos.domain.repositry.TodosRepository
import javax.inject.Inject

class TodosUseCase@Inject constructor(
    private val repository: TodosRepository
) {

    suspend fun getListaTodosUseCase(): List<DatosTodos>{
        return repository.getListaTodos()

    }





}