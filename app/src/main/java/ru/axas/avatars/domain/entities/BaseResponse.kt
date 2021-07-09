package ru.axas.avatars.domain.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BaseResponse <T>(
    @SerializedName("message")
    @Expose
    var message: String? = null,

    @SerializedName("meta")
    @Expose
    var meta: Meta? = null,

    @SerializedName("data")
    @Expose
    var data: T? = null,

    @SerializedName("errors")
    @Expose
    var errors: List<Any>? = null,

    @SerializedName("description")
    @Expose
    var description: String? = null
)

class Meta {
    @SerializedName("pagination")
    @Expose
    var pagination: Pagination? = null
}
class Pagination {
    @SerializedName("page")
    @Expose
    var page: Int? = null

    @SerializedName("total")
    @Expose
    var total: Int? = null

    @SerializedName("has_prev")
    @Expose
    var hasPrev: Boolean? = null

    @SerializedName("has_next")
    @Expose
    var hasNext: Boolean? = null
}