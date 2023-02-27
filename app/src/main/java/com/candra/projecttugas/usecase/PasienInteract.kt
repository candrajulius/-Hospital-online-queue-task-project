package com.candra.projecttugas.usecase

import com.candra.projecttugas.data.Finish
import com.candra.projecttugas.data.Pasien
import com.candra.projecttugas.repository.IRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PasienInteract @Inject constructor(
    private val repository: IRepository
): PasienUseCase{
    override fun showPasienBasedGo(name_go: String): Flow<List<Pasien>> =
        repository.showAllPasienBasedGo(name_go)

    override suspend fun insertPasien(pasien: Pasien) = repository.insertPasien(pasien)

    override suspend fun insertFinish(finish: Finish) = repository.insertFinish(finish)

    override fun showAllFinish(): Flow<List<Finish>> = repository.showAllFinish()
    override suspend fun deletePasien(pasien: Pasien) = repository.deletePasien(pasien)

}