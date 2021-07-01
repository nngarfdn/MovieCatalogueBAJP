package com.nanangarifudin.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.nanangarifudin.moviecatalogue.data.local.LocalDataSource
import com.nanangarifudin.moviecatalogue.data.local.MovieEntity
import com.nanangarifudin.moviecatalogue.data.local.TvShowEntity
import com.nanangarifudin.moviecatalogue.data.remote.RemoteDataSource
import com.nanangarifudin.moviecatalogue.data.remote.response.*
import com.nanangarifudin.moviecatalogue.data.source.MovieTVDataSource
import com.nanangarifudin.moviecatalogue.utils.AppExecutors

class FakeMovieTVRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
    ) : MovieTVDataSource  {


    override fun getMovieDetails(movieId: Int): MutableLiveData<MovieDetailResponse> {
        val result: MutableLiveData<MovieDetailResponse> = MutableLiveData<MovieDetailResponse>()
        remoteDataSource.getMovieDetails(movieId, object : RemoteDataSource.LoadMovieByIdCallback{
            override fun onAllMovieByIdReceived(movieResponse: MovieDetailResponse) {
                var mov = movieResponse
                result.postValue(mov)
            }
        })
        return result
    }

    override fun getMoviePopular(page: Int): MutableLiveData<List<MovieItem>> {
        val courseResults = MutableLiveData<List<MovieItem>>()
        remoteDataSource.getMoviePopular(1, object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(movieResponse: MovieResponse) {
                var courseList = movieResponse.results
                courseResults.postValue(courseList!!)
            }
        })
        return courseResults
    }

    override fun getAllFavoriteMovies(): LiveData<PagedList<MovieEntity>>{
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getBookmarkedMovies(), config).build()
    }

    override fun insertFavoriteMovie(movieEntity: MovieEntity) {
        appExecutors.diskIO().execute { localDataSource.insertMovies(movieEntity) }
    }

    override fun getFavoriteMovieById(movieId: Int): LiveData<MovieEntity> {
        return localDataSource.getBookmarkMovieById(movieId)
    }

    override fun deleteFAvoriteMovie(movieId: Int) {
        appExecutors.diskIO().execute { localDataSource.deleteFavorite(movieId) }
    }

    override fun getTvPopular(page: Int): MutableLiveData<List<TVItem>> {
        val courseResults = MutableLiveData<List<TVItem>>()
        remoteDataSource.getTvPopular(1, object : RemoteDataSource.LoadTVCallback{
            override fun onAllTVReceived(movieResponse: TVResponse) {
                var courseList = movieResponse.results
                courseResults.postValue(courseList!!)
            }
        })
        return courseResults
    }

    override fun getTvDetails(tvId: Int): MutableLiveData<TVDetailResponse> {
        val result: MutableLiveData<TVDetailResponse> = MutableLiveData<TVDetailResponse>()
        remoteDataSource.getTvDetails(tvId, object : RemoteDataSource.LoadTVByIdCallback{
            override fun onAllTVByIdReceived(tvResponse: TVDetailResponse) {
                var mov = tvResponse
                result.postValue(mov)
            }
        })
        return result
    }

    override fun getAllFavoriteTv(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getBookmarkedTvs(), config).build()
    }

    override fun insertFavoriteTv(tvEntity: TvShowEntity) {
        appExecutors.diskIO().execute { localDataSource.insertTvs(tvEntity) }
    }

    override fun getFavoriteTvById(tvId: Int): LiveData<TvShowEntity> {
        return localDataSource.getBookmarkTvById(tvId)
    }

    override fun deleteFAvoriteTv(tvId: Int) {
        appExecutors.diskIO().execute { localDataSource.deleteFavoriteTv(tvId) }
    }



}