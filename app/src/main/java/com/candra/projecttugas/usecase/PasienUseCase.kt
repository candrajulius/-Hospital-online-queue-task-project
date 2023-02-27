package com.candra.projecttugas.usecase

import com.candra.projecttugas.data.Finish
import com.candra.projecttugas.data.Pasien
import kotlinx.coroutines.flow.Flow

interface PasienUseCase {
    fun showPasienBasedGo(name_go: String): Flow<List<Pasien>>
    suspend fun insertPasien(pasien: Pasien)
    suspend fun insertFinish(finish: Finish)
    fun showAllFinish(): Flow<List<Finish>>
    suspend fun deletePasien(pasien: Pasien)
}