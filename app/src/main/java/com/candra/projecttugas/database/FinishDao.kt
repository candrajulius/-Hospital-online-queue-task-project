package com.candra.projecttugas.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.candra.projecttugas.data.Finish
import kotlinx.coroutines.flow.Flow

@Dao
interface FinishDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFinisih(finish: Finish)

    @Query("select * from finish order by finishId asc")
    fun showAllFinishAttempt(): Flow<List<Finish>>
}