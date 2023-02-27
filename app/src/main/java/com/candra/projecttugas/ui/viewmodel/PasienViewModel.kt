package com.candra.projecttugas.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.candra.projecttugas.data.Finish
import com.candra.projecttugas.data.Pasien
import com.candra.projecttugas.usecase.PasienUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PasienViewModel @Inject constructor(
    private val useCase: PasienUseCase
): ViewModel()
{
    fun showAllPasienBasedGo(name_go: String)= useCase.showPasienBasedGo(name_go).asLiveData()
    val showAllFinish = useCase.showAllFinish().asLiveData()

    fun insertPasien(pasien: Pasien) = viewModelScope.launch {
        useCase.insertPasien(pasien)
    }
    fun insertFinsih(finish: Finish) = viewModelScope.launch {
        useCase.insertFinish(finish)
    }

    fun deletePasien(pasien: Pasien) = viewModelScope.launch {
        useCase.deletePasien(pasien)
    }

}