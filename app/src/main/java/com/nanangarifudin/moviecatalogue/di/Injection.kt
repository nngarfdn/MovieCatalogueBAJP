package com.nanangarifudin.moviecatalogue.di

import android.content.Context
import com.nanangarifudin.moviecatalogue.data.remote.RemoteDataSource
import com.nanangarifudin.moviecatalogue.data.MovieTVRepository
import com.nanangarifudin.moviecatalogue.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): MovieTVRepository {

        val remoteDataSource = RemoteDataSource.getInstance()

        return MovieTVRepository.getInstance(remoteDataSource)
    }
}