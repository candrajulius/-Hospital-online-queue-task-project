package com.candra.projecttugas.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.candra.projecttugas.data.Finish
import com.candra.projecttugas.data.Pasien

@Database(entities = [Pasien::class,Finish::class], version = 1, exportSchema = false)
abstract class DatabaseRumahSakit : RoomDatabase(){
    abstract fun pasienDao(): PasienDao
    abstract fun finishDao(): FinishDao
}