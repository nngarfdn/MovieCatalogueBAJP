package com.nanangarifudin.moviecatalogue.data.remote.response


import com.google.gson.annotations.SerializedName

data class GenreX(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null
)