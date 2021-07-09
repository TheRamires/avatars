package ru.axas.avatars.helpers_managers

import android.content.Context
import android.widget.Toast
import dagger.hilt.android.qualifiers.ApplicationContext
import ru.axas.avatars.handlers.HandleOnceTester
import javax.inject.Inject

class ToastyManager @Inject constructor(@ApplicationContext val context: Context, val handleOnceTester: HandleOnceTester){
    fun toasty(message: String){
        if (handleOnceTester.itWasNotHandled(message)){
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
        Loger.log("╝§toasty manager $message")
    }
    fun toasty(message: String, noneOneHandle: Boolean){
        if (noneOneHandle){
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            Loger.log("╝§toasty manager $message")
        } else toasty(message)
    }
}