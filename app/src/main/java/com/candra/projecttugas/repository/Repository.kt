package com.candra.projecttugas.repository

import com.candra.projecttugas.LocalDataSource
import com.candra.projecttugas.data.Finish
import com.candra.projecttugas.data.Pasien
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val localDataSource: LocalDataSource
): IRepository
{
    override fun showAllPasienBasedGo(name_go: String): Flow<List<Pasien>> =
        localDataSource.showPasienBasedGoTo(name_go)

    override suspend fun insertPasien(pasien: Pasien) = localDataSource.insertPasien(pasien)

    override  fun showAllFinish(): Flow<List<Finish>> = localDataSource.showAllFinish()

    override suspend fun insertFinish(finish: Finish) = localDataSource.insertFinish(finish)

    override suspend fun deletePasien(pasien: Pasien) = localDataSource.deletePasien(pasien)

}