package com.candra.projecttugas.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.candra.projecttugas.data.Finish
import com.candra.projecttugas.databinding.CardItemPasienBinding

class AdapterFinish : RecyclerView.Adapter<AdapterFinish.ViewHolder>()
{
    inner class ViewHolder(
        private val binding: CardItemPasienBinding
    ): RecyclerView.ViewHolder(
        binding.root
    )
    {
        fun bind(data: Finish){
            with(binding){
                data.apply {
                    namePasien.text = name_pasien
                    addressPasien.text = alamat_pasien
                    jamMasukPasien.text = jam_masuk
                    nmrTelepon.text = nmr_pasien
                    jamKeluar.text = jam_keluar
                    lamaMenunggu.text = lama_menunggu
                    if (kemana_pergi.equals("poli",true)){
                        poliPasien.text = menu_opsi_poli
                    }else{
                        poliPasien.text = "farmasi"
                    }
                }
                lamaMenunggu.visibility = View.VISIBLE
                titleLamaMenunggu.visibility = View.VISIBLE
                jamKeluar.visibility = View.VISIBLE
                titleJamKeluar.visibility = View.VISIBLE
                statusPasien.text = "Selesai"
                btnFinish.visibility = View.GONE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterFinish.ViewHolder =
        ViewHolder(CardItemPasienBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: AdapterFinish.ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

     val differ = AsyncListDiffer(this,object: DiffUtil.ItemCallback<Finish>(){
         override fun areItemsTheSame(oldItem: Finish, newItem: Finish): Boolean {
             return oldItem.finishId == newItem.finishId
         }

         override fun areContentsTheSame(oldItem: Finish, newItem: Finish): Boolean {
             return oldItem == newItem
         }

     })

    override fun getItemCount(): Int = differ.currentList.size

    fun submitListData(it: List<Finish>){
        differ.submitList(it)
    }
}