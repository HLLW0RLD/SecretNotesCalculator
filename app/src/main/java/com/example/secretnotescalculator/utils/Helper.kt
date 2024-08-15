package com.example.secretnotescalculator.utils

import android.widget.Toast
import com.example.secretnotescalculator.App

object Helper {

    fun toastShort(msg: String) {
        Toast.makeText(App.appInstance, msg, Toast.LENGTH_SHORT).show()
    }

    fun toastLong(msg: String) {
        Toast.makeText(App.appInstance, msg, Toast.LENGTH_LONG).show()
    }
}