package com.candra.projecttugas.di

import com.candra.projecttugas.repository.IRepository
import com.candra.projecttugas.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule{
    @Binds
    abstract fun provideRepository(repository: Repository): IRepository
}