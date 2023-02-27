package com.candra.projecttugas.di

import android.content.Context
import androidx.room.Room
import com.candra.projecttugas.database.DatabaseRumahSakit
import com.candra.projecttugas.database.FinishDao
import com.candra.projecttugas.database.PasienDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
  @Singleton
  @Provides
  fun providesDatabase(@ApplicationContext context: Context): DatabaseRumahSakit =
      Room.databaseBuilder(
          context,
          DatabaseRumahSakit::class.java,"rumah_sakit.db"
      ).fallbackToDestructiveMigration()
          .allowMainThreadQueries().build()

    @Provides
    fun providePasienDao(database: DatabaseRumahSakit): PasienDao = database.pasienDao()

    @Provides
    fun provideFinishDao(database: DatabaseRumahSakit): FinishDao = database.finishDao()
}