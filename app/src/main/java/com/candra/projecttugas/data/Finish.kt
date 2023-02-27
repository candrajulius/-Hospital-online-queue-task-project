package com.candra.projecttugas.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.candra.projecttugas.helper.Constant
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = Constant.NAME_TABLE_FINISH)
data class Finish(
    @PrimaryKey(autoGenerate = true)
    val finishId: Int,

    @ColumnInfo(name = Constant.NAME_PASIEN)
    val name_pasien: String,

    @ColumnInfo(name = Constant.AlAMAT_PASIEN)
    val alamat_pasien: String,

    @ColumnInfo(name = Constant.JAM_MASUK)
    val jam_masuk: String,

    @ColumnInfo(name = Constant.NMR_PASIEN)
    val nmr_pasien: String,

    @ColumnInfo(name = Constant.JAM_KELUAR)
    val jam_keluar: String,

    @ColumnInfo(name = Constant.LAMA_MENUNGGU)
    val lama_menunggu: String,

    @ColumnInfo(name = Constant.MENU_OPSI_POLI)
    val menu_opsi_poli: String,

    @ColumnInfo(name = Constant.KEMANA_PERGI)
    val kemana_pergi: String
): Parcelable