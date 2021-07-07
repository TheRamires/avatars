package ru.axas.avatars.presentation.helpers

import android.util.Log

object Loger {
    private val LOG = "myLog"
    private val turnOn = true // отключить логи по всему приложению


    fun log(message: Any) {
        if (turnOn) {
            Log.d(LOG, "" + message)
        }
    }
    fun log(message: Any, TAG: String) {
        if (turnOn) {
            Log.d(TAG, "" + message)
        }
    }
}