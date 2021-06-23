package com.nanangarifudin.moviecatalogue.data.remote.network

import com.nanangarifudin.moviecatalogue.data.remote.response.MovieDetailResponse
import com.nanangarifudin.moviecatalogue.data.remote.response.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    fun getMoviePopular(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int
    ): Call<MovieResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String?
    ): Call<MovieDetailResponse>
}