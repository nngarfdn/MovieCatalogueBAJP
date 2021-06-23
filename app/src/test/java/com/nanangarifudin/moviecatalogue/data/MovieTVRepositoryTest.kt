package com.nanangarifudin.moviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nanangarifudin.moviecatalogue.data.remote.RemoteDataSource
import com.nanangarifudin.moviecatalogue.utils.DataDummy
import com.nanangarifudin.moviecatalogue.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.*

class MovieTVRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val repository = FakeMovieTVRepository(remote)

    private val movieResponses = DataDummy.generateDummyMovies()
    private val tvResponses = DataDummy.generateDummyTvShows()

    private val movie = movieResponses[0]
    private val movieId = movie.id

    private val tv = tvResponses[0]
    private val tvId = tv.id


    @Test
    fun getAllMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback).onAllMoviesReceived(movieResponses)
            null
        }.`when`(remote).getAllMovies(any())
        val movies = LiveDataTestUtil.getValue(repository.getMovies())
        com.nhaarman.mockitokotlin2.verify(remote).getAllMovies(any())

        Assert.assertNotNull(movies)
        assertEquals(movieResponses.size, movies.size)

    }

    @Test
    fun getAllTV() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTVCallback).onAllTVReceived(tvResponses)
            null
        }.`when`(remote).getAllTV(any())
        val tv = LiveDataTestUtil.getValue(repository.getTVshow())
        verify(remote).getAllTV(any())

        Assert.assertNotNull(tv)
        assertEquals(tvResponses.size, tv.size)

    }

    @Test
    fun getMovieById() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMovieByIdCallback).onAllMovieByIdReceived(movie)
            null
        }.`when`(remote).getAllMovieById(any(), anyInt())
        val movies = LiveDataTestUtil.getValue(repository.getMovieById(movieId!!))
        verify(remote).getAllMovieById(any(), anyInt())

        assertNotNull(movies)
        assertNotNull(movies.title)
        assertEquals(movieResponses[0].title, movies.title)

    }

    @Test
    fun getTVById() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTVByIdCallback).onAllTVByIdReceived(tv)
            null
        }.`when`(remote).getAllTVById(any(), anyInt())
        val tv = LiveDataTestUtil.getValue(repository.getTVById(tvId!!))
        verify(remote).getAllTVById(any(), anyInt())

        assertNotNull(tv)
        assertNotNull(tv.name)
        assertEquals(tvResponses[0].name, tv.name)

    }
}