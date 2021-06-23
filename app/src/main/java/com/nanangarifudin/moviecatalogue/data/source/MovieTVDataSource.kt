package com.nanangarifudin.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nanangarifudin.moviecatalogue.data.remote.response.MovieDetailResponse
import com.nanangarifudin.moviecatalogue.data.remote.response.MovieItem
import com.nanangarifudin.moviecatalogue.data.remote.response.MovieResponse
import com.nanangarifudin.moviecatalogue.data.remote.response.TVResponse

interface MovieTVDataSource {

    fun getMovies(): LiveData<List<MovieResponse>>

    fun getTVshow(): LiveData<List<TVResponse>>

    fun getMovieById(movieId : Int) : LiveData<MovieResponse>

    fun getTVById(movieId : Int) : LiveData<TVResponse>

    fun getMovieDetails(movieId: Int): MutableLiveData<MovieDetailResponse>

    fun getMoviePopular(page: Int): MutableLiveData<List<MovieItem>>

}