package com.candra.projecttugas.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.candra.projecttugas.data.Pasien
import com.candra.projecttugas.databinding.CardItemPasienBinding

class AdapterPasien(
    private val deleteData: (Pasien) -> Unit,
): RecyclerView.Adapter<AdapterPasien.ViewHolder>()
{
    inner class ViewHolder(
        private val binding: CardItemPasienBinding
    ): RecyclerView.ViewHolder(
        binding.root
    )
    {
        fun bind(data: Pasien){
            with(binding)
            {
                data.apply{
                    namePasien.text = name_pasien
                    addressPasien.text = alamat_pasien
                    jamMasukPasien.text = jam_masuk
                    nmrTelepon.text = nmr_pasien
                    if (kemana_pergi_pasien.equals("poli",true)){
                        poliPasien.text = menu_opsi_poli
                    }else if (kemana_pergi_pasien.equals("farmasi")){
                        poliPasien.text = "farmasi"
                    }
                }
                lamaMenunggu.visibility = View.GONE
                titleLamaMenunggu.visibility = View.GONE
                jamKeluar.visibility = View.GONE
                titleJamKeluar.visibility = View.GONE
                statusPasien.text = "Belum Selesai"
                btnFinish.setOnClickListener {
                    deleteData(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            CardItemPasienBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    val differ = AsyncListDiffer(this,object: DiffUtil.ItemCallback<Pasien>(){
        override fun areItemsTheSame(oldItem: Pasien, newItem: Pasien): Boolean {
            return oldItem.pasienId == newItem.pasienId
        }

        override fun areContentsTheSame(oldItem: Pasien, newItem: Pasien): Boolean {
            return oldItem == newItem
        }

    })

    override fun getItemCount(): Int {
       return differ.currentList.size
    }

    fun submitListData(it: List<Pasien>){
        differ.submitList(it)
    }

}