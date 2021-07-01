package com.nanangarifudin.moviecatalogue.ui.movies

import android.graphics.Movie
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nanangarifudin.moviecatalogue.data.MovieTVRepository
import com.nanangarifudin.moviecatalogue.data.local.MovieEntity
import com.nanangarifudin.moviecatalogue.data.remote.response.MovieItem
import com.nanangarifudin.moviecatalogue.data.remote.response.MovieResponse
import com.nanangarifudin.moviecatalogue.utils.DataDummy
import com.nanangarifudin.moviecatalogue.utils.LiveDataTestUtil
import com.nanangarifudin.moviecatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieTVRepository: MovieTVRepository

    @Mock
    private lateinit var observer: Observer<List<MovieItem>>

    @Before
    fun setUp() {
        viewModel = MoviesViewModel(movieTVRepository)
        viewModel.getMovies()
    }

    @Test
    fun getMovie() {
        val movieResponse = MutableLiveData<List<MovieItem>>()
        movieResponse.value = dummyMovie

        Mockito.`when`(movieTVRepository.getMoviePopular(1)).thenReturn(movieResponse)
        val movies = viewModel.getMovies().value

        assertNotNull(movies)
        assertEquals(dummyMovie.size, movies?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }

}