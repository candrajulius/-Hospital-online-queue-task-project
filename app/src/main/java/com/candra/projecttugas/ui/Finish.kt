package com.candra.projecttugas.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.candra.projecttugas.data.Finish
import com.candra.projecttugas.databinding.LayoutItemBinding
import com.candra.projecttugas.helper.Utils
import com.candra.projecttugas.ui.adapter.AdapterFinish
import com.candra.projecttugas.ui.viewmodel.PasienViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Finish : AppCompatActivity(){

    private lateinit var binding: LayoutItemBinding
    private val adapterFinish by lazy {AdapterFinish()}
    private val finishViewModel by viewModels<PasienViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Utils.setToolbar("Finish",supportActionBar)
        finishViewModel.showAllFinish.observe(this,this::showAllDataFinish)
        setAdapter()

    }

    private fun showAllDataFinish(it: List<Finish>){
        adapterFinish.submitListData(it)
    }

    private fun setAdapter(){
        with(binding){
            rvListPasien.apply {
                layoutManager = LinearLayoutManager(this@Finish)
                adapter = adapterFinish
            }
        }
    }
}