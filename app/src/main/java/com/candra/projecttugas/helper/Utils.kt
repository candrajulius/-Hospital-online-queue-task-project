package com.candra.projecttugas.helper

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.ActionBar
import java.text.SimpleDateFormat
import java.util.*

object Utils {

    private const val FORMAT_TIME = "HH:mm:ss"

    fun setToolbar(nameToolbar: String, actionBar: ActionBar?){
        actionBar?.apply {
            title = nameToolbar
        }
    }

    @SuppressLint("ConstantLocale")
    val timeStampt: String = SimpleDateFormat(
        FORMAT_TIME,
        Locale.getDefault()
    ).format(Date())


}