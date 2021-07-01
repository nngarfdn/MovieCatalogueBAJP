package com.nanangarifudin.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nanangarifudin.moviecatalogue.data.MovieTVRepository
import com.nanangarifudin.moviecatalogue.data.local.MovieEntity
import com.nanangarifudin.moviecatalogue.data.local.TvShowEntity
import com.nanangarifudin.moviecatalogue.data.remote.response.MovieDetailResponse
import com.nanangarifudin.moviecatalogue.data.remote.response.TVDetailResponse

class DetailViewModel (private val repository : MovieTVRepository) : ViewModel() {

    fun getMovieById(movieId : Int): LiveData<MovieDetailResponse> = repository.getMovieDetails(movieId)

    fun insertfavorite(movie : MovieEntity) = repository.insertFavoriteMovie(movie)

    fun deletefavorite(movieId: Int) = repository.deleteFAvoriteMovie(movieId)

    fun getFavoriteById(movieId: Int) = repository.getFavoriteMovieById(movieId)

    fun getTvById(movieId : Int): LiveData<TVDetailResponse> = repository.getTvDetails(movieId)

    fun insertfavoriteTv(movie : TvShowEntity) = repository.insertFavoriteTv(movie)

    fun deletefavoriteTv(movieId: Int) = repository.deleteFAvoriteTv(movieId)

    fun getFavoriteTvById(movieId: Int) = repository.getFavoriteTvById(movieId)

}