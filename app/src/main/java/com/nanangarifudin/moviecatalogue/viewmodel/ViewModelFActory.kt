package com.nanangarifudin.moviecatalogue.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nanangarifudin.moviecatalogue.data.MovieTVRepository
import com.nanangarifudin.moviecatalogue.di.Injection
import com.nanangarifudin.moviecatalogue.ui.detail.DetailViewModel
import com.nanangarifudin.moviecatalogue.ui.movies.MoviesViewModel
import com.nanangarifudin.moviecatalogue.ui.tvshow.TVShowViewModel

class ViewModelFactory private constructor(private val mAcademyRepository: MovieTVRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                MoviesViewModel(mAcademyRepository) as T
            }
            modelClass.isAssignableFrom(TVShowViewModel::class.java) -> {
                TVShowViewModel(mAcademyRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(mAcademyRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}