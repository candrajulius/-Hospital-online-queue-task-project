package com.candra.projecttugas.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.candra.projecttugas.helper.Constant
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = Constant.NAME_TABLE_PASIEN)
data class Pasien(
    @PrimaryKey(autoGenerate = true)
    val pasienId: Int,

    @ColumnInfo(name = Constant.NAME_PASIEN)
    val name_pasien: String,

    @ColumnInfo(name = Constant.AlAMAT_PASIEN)
    val alamat_pasien: String,

    @ColumnInfo(name = Constant.KEMANA_PERGI)
    val kemana_pergi_pasien: String,

    @ColumnInfo(name = Constant.JAM_MASUK)
    val jam_masuk: String,

    @ColumnInfo(name = Constant.NMR_PASIEN)
    val nmr_pasien: String,

    @ColumnInfo(name = Constant.MENU_OPSI_POLI)
    val menu_opsi_poli: String

): Parcelable