package ru.axas.avatars.domain.entities

import retrofit2.Call
import retrofit2.Response
import ru.axas.avatars.handlers.NetworkHandler
import ru.axas.avatars.domain.type.Either
import ru.axas.avatars.domain.type.Failure
import javax.inject.Inject

class Request @Inject constructor(val networkHandler: NetworkHandler){
    fun <T : Any> make(call: Call<BaseResponse<T>>): Either<Failure, T> {
        return when (networkHandler.isConnected) {
            true -> execute(call)
            false, null -> Either.Left(Failure.NetworkConnectionError())
        }
    }

    private fun <T : Any> execute(call: Call<BaseResponse<T>>): Either<Failure, T> {
        return try {

            val response = call.execute()

            when (response.code()) {
                200 ->return Either.Right(response.body()!!.data!!)
                401 -> return  Either.Left(Failure.AccessTokenExpired)
                422 -> return  Either.Left(Failure.RefreshTokenExpired)
                else -> {
                    return Either.Left(Failure.ServerError(response.code().toString()))
                }
            }
        } catch (exception: Throwable) {
            Either.Left(Failure.ServerError(exception.message.toString()))
        }
    }
}

fun <T : Any> Response<T>.isSucceed(): Boolean {
    return isSuccessful && body() != null && code()==200
}