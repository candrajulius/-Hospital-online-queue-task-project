package com.candra.projecttugas.di

import com.candra.projecttugas.usecase.PasienInteract
import com.candra.projecttugas.usecase.PasienUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Binds
    @Singleton
    abstract fun providePasienUseCase(pasienInteract: PasienInteract): PasienUseCase
}