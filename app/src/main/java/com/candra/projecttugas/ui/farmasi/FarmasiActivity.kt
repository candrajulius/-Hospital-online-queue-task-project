package com.candra.projecttugas.ui.farmasi

import android.os.Build
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.candra.projecttugas.data.Finish
import com.candra.projecttugas.data.Pasien
import com.candra.projecttugas.databinding.LayoutItemBinding
import com.candra.projecttugas.helper.Utils
import com.candra.projecttugas.ui.adapter.AdapterPasien
import com.candra.projecttugas.ui.viewmodel.PasienViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@AndroidEntryPoint
class FarmasiActivity: AppCompatActivity(){

    private lateinit var binding: LayoutItemBinding
    private val adapterFarmasi by lazy { AdapterPasien(::onDelete) }
    private val pasienViewModel by viewModels<PasienViewModel>()
    private val nameFarmasi = "farmasi"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Utils.setToolbar("Farmasi",supportActionBar)
        pasienViewModel.showAllPasienBasedGo("%$nameFarmasi%").observe(this,this::showAllDataPasien)
        setAdapter()
    }

    private fun showAllDataPasien(it: List<Pasien>){
        adapterFarmasi.submitListData(it)
    }

    private fun setAdapter(){
        with(binding){
            rvListPasien.apply {
                layoutManager = LinearLayoutManager(this@FarmasiActivity)
                adapter = adapterFarmasi
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun onDelete(pasien: Pasien){
        val jamMasuk = pasien.jam_masuk
        val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
        val jamKeluar = LocalDateTime.now().format(formatter)

        val localtimeMasuk = LocalTime.parse(jamMasuk)
        val localTimeKeluar = LocalTime.parse(jamKeluar)

        var diffrenceTime = Duration.between(localtimeMasuk,localTimeKeluar)

        val hours: Long = diffrenceTime.toHours()
        diffrenceTime = diffrenceTime.minusHours(hours)
        val minutes: Long = diffrenceTime.toMinutes()
        diffrenceTime = diffrenceTime.minusMinutes(minutes)
        val seconds: Long = diffrenceTime.getSeconds()

        val lamaMenungu = "$hours jam : $minutes menit : $seconds detik"

        val finishPasien = Finish(
            pasien.pasienId,
            pasien.name_pasien,
            pasien.alamat_pasien,
            pasien.jam_masuk,pasien.nmr_pasien,jamKeluar,lamaMenungu,pasien.menu_opsi_poli,pasien.kemana_pergi_pasien)
        adapterFarmasi.notifyItemRemoved(pasien.pasienId)
        pasienViewModel.insertFinsih(finishPasien)
        pasienViewModel.deletePasien(pasien)
    }
}

