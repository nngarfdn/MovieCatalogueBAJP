package com.nanangarifudin.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nanangarifudin.moviecatalogue.data.MovieTVRepository
import com.nanangarifudin.moviecatalogue.data.remote.response.MovieDetailResponse

class DetailViewModel (private val repository : MovieTVRepository) : ViewModel() {

    fun getMovieById(movieId : Int): LiveData<MovieDetailResponse> = repository.getMovieDetails(movieId)
//
//    fun getTVById(tvId : Int) : LiveData<TVResponse> = repository.getTVById(tvId)

}