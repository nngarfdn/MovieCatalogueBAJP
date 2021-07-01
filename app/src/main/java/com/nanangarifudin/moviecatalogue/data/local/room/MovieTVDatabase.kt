package com.nanangarifudin.moviecatalogue.data.local.room

import android.content.Context

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nanangarifudin.moviecatalogue.data.local.MovieEntity
import com.nanangarifudin.moviecatalogue.data.local.TvShowEntity


@Database(entities = [MovieEntity::class, TvShowEntity::class],
        version = 2,
        exportSchema = false)
abstract class MovieTVDatabase : RoomDatabase() {
    abstract fun movieTVDao(): MovieTvDao

    companion object {

        @Volatile
        private var INSTANCE: MovieTVDatabase? = null

        fun getInstance(context: Context): MovieTVDatabase =
                INSTANCE ?: synchronized(this) {
                    Room.databaseBuilder(
                            context.applicationContext,
                            MovieTVDatabase::class.java,
                            "fav.db"
                    ).build().apply {
                        INSTANCE = this
                    }
                }
    }
}