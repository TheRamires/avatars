package ru.axas.avatars.data.network_services

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import ru.axas.avatars.domain.entities.BaseResponse

interface TokenService {
    @POST("/../")
    fun refreshToken (@Body refresh: Map<String, String>): Call<BaseResponse<Any>>
}