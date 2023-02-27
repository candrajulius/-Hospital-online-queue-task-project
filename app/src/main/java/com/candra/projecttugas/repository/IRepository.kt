package com.candra.projecttugas.repository

import com.candra.projecttugas.data.Finish
import com.candra.projecttugas.data.Pasien
import kotlinx.coroutines.flow.Flow

interface IRepository {

    fun showAllPasienBasedGo(name_go: String): Flow<List<Pasien>>

    suspend fun insertPasien(pasien: Pasien)

    fun showAllFinish(): Flow<List<Finish>>

    suspend fun insertFinish(finish: Finish)

    suspend fun deletePasien(pasien: Pasien)

}