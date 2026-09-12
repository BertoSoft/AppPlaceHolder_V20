package com.example.appplaceholder_v20.core.mappers

import com.example.appplaceholder_v20.core.model.DatosTodosDto
import com.example.appplaceholder_v20.modulos.todos.domain.model.DatosTodos


fun DatosTodosDto.toDomain(): DatosTodos{
    return DatosTodos(
        userId = this.usserId.toString(),
        id = this.Id.toString(),
        title = this.title,
        completed = this.completed.toString()
    )
}