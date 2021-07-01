package com.nanangarifudin.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.nanangarifudin.moviecatalogue.data.local.MovieEntity
import com.nanangarifudin.moviecatalogue.data.local.TvShowEntity
import com.nanangarifudin.moviecatalogue.data.remote.response.*
import com.nanangarifudin.moviecatalogue.vo.Resource

interface MovieTVDataSource {

    //movie remote
    fun getMoviePopular(page: Int): MutableLiveData<List<MovieItem>>
    fun getMovieDetails(movieId: Int): MutableLiveData<MovieDetailResponse>
    //movie local
    fun getAllFavoriteMovies(): LiveData<PagedList<MovieEntity>>
    fun insertFavoriteMovie(movieEntity: MovieEntity)
    fun getFavoriteMovieById(movieId: Int) : LiveData<MovieEntity>
    fun deleteFAvoriteMovie(movieId: Int)

    //tv remote
    fun getTvPopular(page: Int): MutableLiveData<List<TVItem>>
    fun getTvDetails(tvId: Int): MutableLiveData<TVDetailResponse>
    //tv local
    fun getAllFavoriteTv(): LiveData<PagedList<TvShowEntity>>
    fun insertFavoriteTv(tvEntity: TvShowEntity)
    fun getFavoriteTvById(tvId: Int) : LiveData<TvShowEntity>
    fun deleteFAvoriteTv(tvId: Int)

}