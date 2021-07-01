package com.nanangarifudin.moviecatalogue.ui.favorite.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.nanangarifudin.moviecatalogue.data.MovieTVRepository

class FavoriteTvShowViewModel(private val repository : MovieTVRepository) : ViewModel()  {

    fun getAllFavorite() = repository.getAllFavoriteTv()

}