package ru.axas.avatars.data.repositories

import ru.axas.avatars.data.network_services.TokenService
import ru.axas.avatars.domain.REFRESH_TOKEN
import ru.axas.avatars.domain.type.Either
import ru.axas.avatars.domain.type.Failure
import ru.axas.avatars.domain.entities.Token

abstract class BaseRepo (
        val tokenService: TokenService,
        val token: Token
) {
    abstract fun <T, R> load (t: T):Either<Failure, R>
    abstract fun <T>save (t: T)

    fun <T>checkToken(request: Either<Failure, T>): Boolean{
        return (request is Either.Left && request.a== Failure.AccessTokenExpired)
    }

    fun <T>refreshToken(){
        //refreshing is finished
        val refresh: String=token.loadRefreshToken()!!
        val request = HashMap<String,String>()
        request[REFRESH_TOKEN] = refresh
        tokenService.refreshToken(request)
    }
}