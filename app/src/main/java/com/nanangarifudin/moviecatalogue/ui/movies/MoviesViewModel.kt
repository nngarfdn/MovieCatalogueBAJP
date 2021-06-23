package com.nanangarifudin.moviecatalogue.ui.movies

import androidx.lifecycle.*
import com.nanangarifudin.moviecatalogue.data.MovieTVRepository
import com.nanangarifudin.moviecatalogue.data.remote.response.MovieItem

class MoviesViewModel (private val repository : MovieTVRepository) : ViewModel() {

    fun getMovies(): LiveData<List<MovieItem>> = repository.getMoviePopular(1)

}