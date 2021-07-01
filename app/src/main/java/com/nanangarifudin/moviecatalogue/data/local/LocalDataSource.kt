package com.nanangarifudin.moviecatalogue.data.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Query
import androidx.room.Update

import com.nanangarifudin.moviecatalogue.data.local.room.MovieTvDao

class LocalDataSource private constructor(private val mAcademyDao: MovieTvDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(academyDao: MovieTvDao): LocalDataSource =
                INSTANCE ?: LocalDataSource(academyDao).apply { INSTANCE = this }
    }

    fun getBookmarkedMovies(): DataSource.Factory<Int, MovieEntity> = mAcademyDao.getBookmarkedMovie()

    fun insertMovies(courses: MovieEntity) = mAcademyDao.insertMovies(courses)

    fun getBookmarkMovieById(moduleId: Int): LiveData<MovieEntity> =
            mAcademyDao.getMovieById(moduleId)

    fun deleteFavorite(moduleId: Int) {
        mAcademyDao.deleteFavorite(moduleId)
    }

    fun getBookmarkedTvs(): DataSource.Factory<Int, TvShowEntity> = mAcademyDao.getBookmarkedTv()

    fun insertTvs(courses: TvShowEntity) = mAcademyDao.insertTv(courses)

    fun getBookmarkTvById(moduleId: Int): LiveData<TvShowEntity> =
        mAcademyDao.getTvById(moduleId)

    fun deleteFavoriteTv(moduleId: Int) {
        mAcademyDao.deleteFavoriteTv(moduleId)
    }




}