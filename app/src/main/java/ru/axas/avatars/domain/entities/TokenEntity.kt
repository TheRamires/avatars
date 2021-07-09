package ru.axas.avatars.domain.entities

import android.content.SharedPreferences
import ru.axas.avatars.domain.ACCESS
import ru.axas.avatars.domain.REFRESH
import ru.axas.avatars.helpers_managers.Loger
import javax.inject.Inject

class TokenEntity @Inject constructor(val sharedPreferences: SharedPreferences): Token {

    override fun loadRefreshToken(): String?{
        if(
            sharedPreferences.contains(REFRESH)) {
            Loger.log(" ♦ LOAD REFRESHTOKEN "+sharedPreferences.getString(REFRESH," "))
            return sharedPreferences.getString(REFRESH,"")
        }
        return null
    }
    override fun loadAccesToken(): String?{
        if(sharedPreferences.contains(ACCESS)) {
            Loger.log(" ♦ LOAD ACCESSTOKEN "+sharedPreferences.getString(ACCESS," "))
            val loadTok=sharedPreferences.getString(ACCESS,"")
            val accesToken="Token "+loadTok
            return accesToken
        } else {
            Loger.log(" ♦ LOAD ACCESSTOKEN is not found") }
        return null
    }

    override fun saveRefreshToken(refreshToken: String){

        Loger.log(" ♦ SAVE REFRESHTOKEN " +refreshToken)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(REFRESH, refreshToken)
        editor.apply()
    }
    override fun saveAccesToken(accesToken: String){
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        Loger.log(" ♦ SAVE accesToken " +accesToken)
        //editor.remove(ACCESS)
        editor.putString(ACCESS, accesToken)
        editor.apply()
    }

    //при выходе из приложения
    override fun deleteAccesToken() {
        if(sharedPreferences.contains(ACCESS)){
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.remove(ACCESS)
            editor.apply()
            loadAccesToken() //Проверка
        }
    }
}