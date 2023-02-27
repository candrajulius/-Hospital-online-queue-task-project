package com.candra.projecttugas.database

import androidx.room.*
import com.candra.projecttugas.data.Pasien
import kotlinx.coroutines.flow.Flow

@Dao
interface PasienDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPasien(pasien: Pasien)


    @Query("select * from pasien where kemana_pergi like :nama_temoat")
    fun showAllPasienBasedToGo(nama_temoat: String): Flow<List<Pasien>>

    @Delete
    suspend fun deletePasien(pasien: Pasien)
}