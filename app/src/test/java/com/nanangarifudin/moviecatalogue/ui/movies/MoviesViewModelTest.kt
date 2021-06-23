package com.nanangarifudin.moviecatalogue.ui.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nanangarifudin.moviecatalogue.data.MovieTVRepository
import com.nanangarifudin.moviecatalogue.utils.DataDummy
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
    private lateinit var observer: Observer<List<MovieResponse>>

    @Before
    fun setUp() {
        viewModel = MoviesViewModel(movieTVRepository)
        viewModel.getMovies()
    }

    @Test
    fun getMovie() {
        val movieResponse = MutableLiveData<List<MovieResponse>>()
        movieResponse.value = dummyMovie

        Mockito.`when`(movieTVRepository.getMovies()).thenReturn(movieResponse)
        val movies = viewModel.getMovies().value

        assertNotNull(movies)
        assertEquals(dummyMovie.size, movies?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }
}