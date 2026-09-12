package com.example.appplaceholder_v20.core.mappers

import com.example.appplaceholder_v20.core.model.DatosCommentsDto
import com.example.appplaceholder_v20.modulos.comment.domain.model.DatosComments


fun DatosCommentsDto.toDomain(): DatosComments{
    return DatosComments(
        id = this.id.toString(),
        postId = this.postId.toString(),
        name = this.nombre,
        email = this.eMail,
        body = this.cuerpo
    )
}