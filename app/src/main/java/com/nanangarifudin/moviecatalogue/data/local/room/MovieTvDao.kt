package com.nanangarifudin.moviecatalogue.data.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery
import com.nanangarifudin.moviecatalogue.data.local.MovieEntity
import com.nanangarifudin.moviecatalogue.data.local.TvShowEntity

@Dao
interface MovieTvDao {

    @Query("SELECT * FROM favoritemovie")
    fun getMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM favoritemovie where bookmarked = 1")
    fun getBookmarkedMovie(): DataSource.Factory<Int, MovieEntity>

    @Transaction
    @Query("SELECT * FROM favoritemovie WHERE id = :id")
    fun getMovieById(id: Int): LiveData<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movie: MovieEntity)

    @Delete
    fun deleteFavorite(favorite: MovieEntity?)

    @Query("DELETE FROM favoritemovie WHERE id = :favoriteId")
    fun deleteFavorite(favoriteId: Int)

    @Update
    fun updateMovie(movie: MovieEntity)



    @Query("SELECT * FROM favoritetv")
    fun getTvs(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM favoritetv where bookmarked = 1")
    fun getBookmarkedTv(): DataSource.Factory<Int, TvShowEntity>

    @Transaction
    @Query("SELECT * FROM favoritetv WHERE id = :id")
    fun getTvById(id: Int): LiveData<TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTv(movie: TvShowEntity)

    @Delete
    fun deleteFavoriteTv(favorite: TvShowEntity?)

    @Query("DELETE FROM favoritetv WHERE id = :favoriteId")
    fun deleteFavoriteTv(favoriteId: Int)

    @Update
    fun updateTv(movie: TvShowEntity)





}