package com.candra.projecttugas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.candra.projecttugas.databinding.ActivityMainBinding
import com.candra.projecttugas.ui.Finish
import com.candra.projecttugas.ui.farmasi.FarmasiActivity
import com.candra.projecttugas.ui.pendaftaran.PendaftaranActivity
import com.candra.projecttugas.ui.poli.Poli
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar()
        with(binding){
            cardRegister.setOnClickListener {
                startActivity(Intent(this@MainActivity,PendaftaranActivity::class.java))
            }
            cardPoli.setOnClickListener {
                startActivity(
                    Intent(this@MainActivity,Poli::class.java)
                )
            }
            cardFarmasi.setOnClickListener {
                startActivity(
                    Intent(this@MainActivity,FarmasiActivity::class.java)
                )
            }
            cardFinish.setOnClickListener {
                startActivity(
                    Intent(this@MainActivity,Finish::class.java)
                )
            }
        }
    }

    private fun setToolbar(){
        supportActionBar?.apply {
            title = "UAS MOSi"
            subtitle = "RSIA ROSIVA"
        }
    }
}