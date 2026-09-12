package com.example.appplaceholder_v20.core.di

import com.example.appplaceholder_v20.core.repositoryImpl.TodosRepositoryImpl
import com.example.appplaceholder_v20.modulos.todos.domain.repositry.TodosRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract  class TodosModulo {
    @Binds
    @Singleton
    abstract fun bindTodosRepository(
        todosRepositoryImpl: TodosRepositoryImpl
    ): TodosRepository
}