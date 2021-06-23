package com.nanangarifudin.moviecatalogue.data.remote.response


import com.google.gson.annotations.SerializedName

data class TVResponse(
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("results")
    val results: List<TVItem>? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null,
    @SerializedName("total_results")
    val totalResults: Int? = null
)