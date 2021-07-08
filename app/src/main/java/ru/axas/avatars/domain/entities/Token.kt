package ru.axas.avatars.domain.entities

interface Token {
    fun loadRefreshToken(): String?
    fun loadAccesToken(): String?
    fun saveRefreshToken(refreshToken: String)
    fun saveAccesToken(accesToken: String)
    fun deleteAccesToken()
}