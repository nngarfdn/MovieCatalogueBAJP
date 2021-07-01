package com.nanangarifudin.moviecatalogue.data.remote.response


import com.google.gson.annotations.SerializedName

data class SpokenLanguageX(
    @SerializedName("english_name")
    val englishName: String? = null,
    @SerializedName("iso_639_1")
    val iso6391: String? = null,
    @SerializedName("name")
    val name: String? = null
)