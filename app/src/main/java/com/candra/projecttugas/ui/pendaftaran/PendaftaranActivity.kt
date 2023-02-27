package com.candra.projecttugas.ui.pendaftaran

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.RadioButton
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.candra.projecttugas.R
import com.candra.projecttugas.data.Pasien
import com.candra.projecttugas.databinding.LayoutPendfataranBinding
import com.candra.projecttugas.helper.Utils
import com.candra.projecttugas.ui.viewmodel.PasienViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PendaftaranActivity : AppCompatActivity(){

    private lateinit var binding: LayoutPendfataranBinding
    private var selectedValue = ""
    private val pasienViewModel by viewModels<PasienViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutPendfataranBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Utils.setToolbar("Pendaftaran",supportActionBar)

        with(binding){

            btnKirim.setOnClickListener {
                validationData()
                finish()
            }
            mtvSubtitleJamMasuk.text = Utils.timeStampt
        }

        setAdapterData()
    }

     fun choosePoli(view: View){
        if  (view is RadioButton){
            when (view.id){
                R.id.rb_poli -> {
                    showMenuPoli(true)
                    selectedValue = "poli"
                }
                R.id.rb_farmasi -> {
                    showMenuPoli(false)
                    selectedValue = "farmasi"
                }
            }
        }
    }

    private fun setAdapterData(){
        val data: Array<String> = resources.getStringArray(R.array.opsi_poli)
        val arrayAdapter = ArrayAdapter(this@PendaftaranActivity, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,data)
        binding.atMenuPoli.setAdapter(arrayAdapter)
    }

    private fun showMenuPoli(isShow: Boolean){
        binding.menuPoli.visibility = if (isShow) View.VISIBLE else View.GONE
    }


    private fun validationData(){
        with(binding){
            val namePasien = textFieldName.editText?.text.toString()
            val addressPasien = textFieldAlamat.editText?.text.toString()
            val nmrHandphonePasien = textFieldNmrHandphone.editText?.text.toString()
            val menuDataGo = menuPoli.editText?.text.toString()


            if (namePasien.isEmpty()){
                textFieldName.error = "Nama tidak boleh kosong"
            }else if (addressPasien.isEmpty()){
                textFieldName.error = "Alamat tidak boleh kosong"
            }else if (nmrHandphonePasien.isEmpty()){
                textFieldNmrHandphone.error = "Nomor Handphone tidak boleh kosong"
            }else if (menuDataGo.isEmpty()){
                menuPoli.error = "Opsi poli tidak boleh kosong"
            }else{
                val jamMasuk = mtvSubtitleJamMasuk.text.toString()

                val pasien = Pasien(0,
                namePasien,addressPasien,selectedValue,jamMasuk,nmrHandphonePasien,menuDataGo)
                pasienViewModel.insertPasien(pasien)

            }

        }
    }
}