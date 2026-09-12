package com.example.appplaceholder_v20.core.datasource

import com.example.appplaceholder_v20.core.di.IoDispatcher
import com.example.appplaceholder_v20.core.model.DatosCommentsDto
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class CommentsDataSorce @Inject constructor(
    private val apiService: ApiService,
    @IoDispatcher private val ioDispacher: CoroutineDispatcher
) {


}