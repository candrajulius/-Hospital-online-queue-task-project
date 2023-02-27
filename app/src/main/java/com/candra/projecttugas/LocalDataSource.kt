package com.candra.projecttugas

import com.candra.projecttugas.data.Finish
import com.candra.projecttugas.data.Pasien
import com.candra.projecttugas.database.FinishDao
import com.candra.projecttugas.database.PasienDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val pasienDao: PasienDao,
    private val finishDao: FinishDao
){
    fun showPasienBasedGoTo(name_go: String): Flow<List<Pasien>> = pasienDao.showAllPasienBasedToGo(name_go)

    suspend fun insertPasien(pasien: Pasien) = pasienDao.insertPasien(pasien)

    suspend fun insertFinish(finish: Finish) = finishDao.insertFinisih(finish)

    fun showAllFinish(): Flow<List<Finish>> = finishDao.showAllFinishAttempt()

    suspend fun deletePasien(pasien: Pasien) = pasienDao.deletePasien(pasien)
}