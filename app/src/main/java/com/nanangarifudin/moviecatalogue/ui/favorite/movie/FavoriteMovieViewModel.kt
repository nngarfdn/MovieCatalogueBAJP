package com.nanangarifudin.moviecatalogue.ui.favorite.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.nanangarifudin.moviecatalogue.data.MovieTVRepository

class FavoriteMovieViewModel(private val repository : MovieTVRepository) : ViewModel()  {

    fun getAllFavorite() = repository.getAllFavoriteMovies()


}