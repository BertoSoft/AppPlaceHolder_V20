package com.example.appplaceholder_v20.core.di

import com.example.appplaceholder_v20.core.repositoryImpl.CommentsRepositoryImpl
import com.example.appplaceholder_v20.modulos.comment.domain.repository.CommentsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract  class HomeModulo {
    @Binds
    @Singleton
    abstract fun bindHomeRepository(
        commentsRepositoryImpl: CommentsRepositoryImpl
    ): CommentsRepository
}