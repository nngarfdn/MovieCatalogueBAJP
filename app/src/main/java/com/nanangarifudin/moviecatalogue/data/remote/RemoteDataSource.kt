package com.nanangarifudin.moviecatalogue.data.remote

import android.os.Handler
import android.os.Looper
import android.util.Log
import com.nanangarifudin.moviecatalogue.R
import com.nanangarifudin.moviecatalogue.data.remote.network.ApiConfig
import com.nanangarifudin.moviecatalogue.data.remote.response.MovieDetailResponse
import com.nanangarifudin.moviecatalogue.data.remote.response.MovieResponse
import com.nanangarifudin.moviecatalogue.data.remote.response.TVDetailResponse
import com.nanangarifudin.moviecatalogue.data.remote.response.TVResponse
import com.nanangarifudin.moviecatalogue.utils.EspressoIdlingResource
import com.nanangarifudin.moviecatalogue.utils.JsonHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource  {

    private val handler = Handler(Looper.getMainLooper())


    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000
        private const val TAG = "RemoteDataSource"
        private const val APIKEY = "732012d703178472fe5df9861a323d1d"

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource().apply { instance = this }
            }
    }

    fun getMoviePopular(
        page: Int,
        callback: LoadMoviesCallback
    ) {
        EspressoIdlingResource.increment()
        val client: Call<MovieResponse> =
            ApiConfig.getApiService().getMoviePopular(APIKEY, page)
        client.enqueue(object : Callback<MovieResponse?> {
            override fun onResponse(
                call: Call<MovieResponse?>,
                response: Response<MovieResponse?>
            ) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        callback.onAllMoviesReceived(response.body()!!)
                        EspressoIdlingResource.decrement()
                    }
                } else Log.e(TAG, "onFailure: " + response.message())
            }

            override fun onFailure(call: Call<MovieResponse?>, t: Throwable) {
                Log.e(TAG, "onFailure: " + t.message)
            }
        })
    }

    fun getMovieDetails(
        movieId: Int,
        callback: LoadMovieByIdCallback
    ) {
        EspressoIdlingResource.increment()
        val client: Call<MovieDetailResponse> =
            ApiConfig.getApiService().getMovieDetails(movieId, APIKEY)
        client.enqueue(object : Callback<MovieDetailResponse?> {
            override fun onResponse(
                call: Call<MovieDetailResponse?>,
                response: Response<MovieDetailResponse?>
            ) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onAllMovieByIdReceived(response.body()!!)
                        EspressoIdlingResource.decrement()
                    }
                } else Log.e(TAG, "onFailure: " + response.message())
            }

            override fun onFailure(call: Call<MovieDetailResponse?>, t: Throwable) {
                Log.e(TAG, "onFailure: " + t.message)
            }
        })
    }


    fun getTvPopular(
        page: Int,
        callback: LoadTVCallback
    ) {
        EspressoIdlingResource.increment()
        val client: Call<TVResponse> =
            ApiConfig.getApiService().getTVPopular(APIKEY, page)
        client.enqueue(object : Callback<TVResponse?> {
            override fun onResponse(
                call: Call<TVResponse?>,
                response: Response<TVResponse?>
            ) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        callback.onAllTVReceived(response.body()!!)
                        EspressoIdlingResource.decrement()
                    }
                } else Log.e(TAG, "onFailure: " + response.message())
            }

            override fun onFailure(call: Call<TVResponse?>, t: Throwable) {
                Log.e(TAG, "onFailure: " + t.message)
            }
        })
    }

    fun getTvDetails(
        id: Int,
        callback: LoadTVByIdCallback
    ) {
        EspressoIdlingResource.increment()
        val client: Call<TVDetailResponse> =
            ApiConfig.getApiService().getTVDetails(id, APIKEY)
        client.enqueue(object : Callback<TVDetailResponse?> {
            override fun onResponse(
                call: Call<TVDetailResponse?>,
                response: Response<TVDetailResponse?>
            ) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onAllTVByIdReceived(response.body()!!)
                        EspressoIdlingResource.decrement()
                    }
                } else Log.e(TAG, "onFailure: " + response.message())
            }

            override fun onFailure(call: Call<TVDetailResponse?>, t: Throwable) {
                Log.e(TAG, "onFailure: " + t.message)
            }
        })
    }


    interface LoadMoviesCallback {
        fun onAllMoviesReceived(movieResponse: MovieResponse)
    }

    interface LoadMovieByIdCallback {
        fun onAllMovieByIdReceived(movieResponse: MovieDetailResponse)
    }

    interface LoadTVByIdCallback {
        fun onAllTVByIdReceived(tvResponse: TVDetailResponse)
    }

    interface LoadTVCallback {
        fun onAllTVReceived(movieResponse: TVResponse)
    }

}

