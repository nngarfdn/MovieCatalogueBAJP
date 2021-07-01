package com.nanangarifudin.moviecatalogue.di

import android.content.Context
import com.nanangarifudin.moviecatalogue.data.remote.RemoteDataSource
import com.nanangarifudin.moviecatalogue.data.MovieTVRepository
import com.nanangarifudin.moviecatalogue.data.local.LocalDataSource
import com.nanangarifudin.moviecatalogue.data.local.room.MovieTVDatabase
import com.nanangarifudin.moviecatalogue.utils.AppExecutors
import com.nanangarifudin.moviecatalogue.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): MovieTVRepository {

        val database = MovieTVDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.movieTVDao())
        val appExecutors = AppExecutors()

        return MovieTVRepository.getInstance(remoteDataSource, localDataSource,appExecutors)
    }
}