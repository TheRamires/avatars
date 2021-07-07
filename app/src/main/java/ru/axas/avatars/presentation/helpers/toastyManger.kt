package ru.axas.avatars.presentation.helpers

import android.widget.Toast

class toastyManger {
    fun toasty(message: String?){
        Toast.makeText(context,message, Toast.LENGTH_SHORT).show()
    }
}