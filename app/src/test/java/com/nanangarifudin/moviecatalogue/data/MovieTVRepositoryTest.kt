package com.nanangarifudin.moviecatalogue.data

import android.graphics.Movie
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.nanangarifudin.moviecatalogue.data.local.LocalDataSource
import com.nanangarifudin.moviecatalogue.data.local.MovieEntity
import com.nanangarifudin.moviecatalogue.data.local.TvShowEntity
import com.nanangarifudin.moviecatalogue.data.remote.ApiResponse
import com.nanangarifudin.moviecatalogue.data.remote.RemoteDataSource
import com.nanangarifudin.moviecatalogue.data.remote.response.*
import com.nanangarifudin.moviecatalogue.utils.AppExecutors
import com.nanangarifudin.moviecatalogue.utils.DataDummy
import com.nanangarifudin.moviecatalogue.utils.LiveDataTestUtil
import com.nanangarifudin.moviecatalogue.utils.PagedListUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.invocation.InvocationOnMock
import org.mockito.stubbing.Answer

class MovieTVRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val repository = FakeMovieTVRepository(remote,local,appExecutors)

    val movieResponses = MovieResponse(results = DataDummy.generateDummyMovies())
    val tvResponses = TVResponse(results = DataDummy.generateDummyTvShows())

    private val movie = movieResponses.results?.get(0)
    val movDetail = MovieDetailResponse(
        id = movie?.id, title = movie?.title,
        overview = movie?.overview, posterPath = movie?.posterPath)
    private val movieId = movie?.id

    private val tv = tvResponses.results?.get(0)
    val tvDetail = TVDetailResponse(
        id = tv?.id, name = tv?.name,
        overview = tv?.overview, posterPath = tv?.posterPath)
    private val tvId = tv?.id

    @Test
    fun getMoviePopular() {
        val movieResponse = movieResponses
        Mockito.doAnswer { invocation: InvocationOnMock ->
            (invocation.arguments[1] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(movieResponse)
            null
        }.`when`(remote).getMoviePopular(
            ArgumentMatchers.eq(1), any()
        )
        val movieEntities: List<MovieItem> =
            LiveDataTestUtil.getValue(repository.getMoviePopular(1))!!
        verify(remote).getMoviePopular(
            ArgumentMatchers.eq(1), any()
        )
        Assert.assertNotNull(movieEntities)
        assertEquals(movieResponse.results?.size, movieEntities.size)
    }

    @Test
    fun getTvPopular() {
        val tvResponse = tvResponses
        Mockito.doAnswer { invocation: InvocationOnMock ->
            (invocation.arguments[1] as RemoteDataSource.LoadTVCallback)
                .onAllTVReceived(tvResponse)
            null
        }.`when`(remote).getTvPopular(
            ArgumentMatchers.eq(1), any()
        )
        val tvEntities: List<TVItem> =
            LiveDataTestUtil.getValue(repository.getTvPopular(1))!!
        verify(remote).getTvPopular(
            ArgumentMatchers.eq(1), any()
        )
        Assert.assertNotNull(tvEntities)
        assertEquals(tvResponse.results?.size, tvEntities.size)
    }

    @Test
    fun getMovieDetails() {
        Mockito.doAnswer { invocation: InvocationOnMock ->
            (invocation.arguments[1] as RemoteDataSource.LoadMovieByIdCallback)
                .onAllMovieByIdReceived(movDetail)
            null
        }.`when`(remote).getMovieDetails(
            eq(movieId)!!, any()
        )

        val movieDetailsEntity: MovieDetailResponse =
            LiveDataTestUtil.getValue(repository.getMovieDetails(movieId!!))!!
        verify(remote).getMovieDetails(
            eq(movieId)!!, any()
        )

        Assert.assertNotNull(movieDetailsEntity)
        assertEquals(movieDetailsEntity.title, movDetail.title)
    }

    @Test
    fun getTvDetails() {
        Mockito.doAnswer { invocation: InvocationOnMock ->
            (invocation.arguments[1] as RemoteDataSource.LoadTVByIdCallback)
                .onAllTVByIdReceived(tvDetail)
            null
        }.`when`(remote).getTvDetails(
            eq(tvId)!!, any()
        )

        val tvDetailsEntity: TVDetailResponse =
            LiveDataTestUtil.getValue(repository.getTvDetails(tvId!!))!!
        verify(remote).getTvDetails(
            eq(tvId), any()
        )

        Assert.assertNotNull(tvDetailsEntity)
        assertEquals(tvDetailsEntity.name, tvDetail.name)
    }


    @Test
    fun getFavoriteMovie() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getBookmarkedMovies()).thenReturn(dataSourceFactory)
        repository.getAllFavoriteMovies()

        val movieEntities =
            PagedListUtil.mockPagedList(DataDummy.generateDummyMovies())
        verify(local).getBookmarkedMovies()
        assertNotNull(movieEntities)
        assertEquals(movieResponses.results?.size, movieEntities.size)
    }

    @Test
    fun getFavoriteTv() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getBookmarkedTvs()).thenReturn(dataSourceFactory)
        repository.getAllFavoriteTv()

        val tvEntities =
            PagedListUtil.mockPagedList(DataDummy.generateDummyTvShows())
        verify(local).getBookmarkedTvs()
        assertNotNull(tvEntities)
        assertEquals(movieResponses.results?.size, tvEntities.size)
    }

    @Test
    fun getFavoriteMovieById() {
        val dummyEntity = MutableLiveData<MovieEntity>()
        val mov = DataDummy.generateDummyMovies()[0]
        dummyEntity.value =  MovieEntity(mov.id, mov.title, mov.overview, true, mov.posterPath)
        `when`<LiveData<MovieEntity>>(local.getBookmarkMovieById(mov.id!!)).thenReturn(dummyEntity)

        val courseEntitiesContent = LiveDataTestUtil.getValue(repository.getFavoriteMovieById(mov.id!!))
        verify(local).getBookmarkMovieById(mov.id!!)
        Assert.assertNotNull(courseEntitiesContent)
        assertEquals(mov.title, courseEntitiesContent?.title)
    }

    @Test
    fun getFavoriteTvById() {
        val dummyEntity = MutableLiveData<TvShowEntity>()
        val tv = DataDummy.generateDummyTvShows()[0]
        dummyEntity.value =  TvShowEntity(tv.id, tv.name, tv.overview, true, tv.posterPath)
        `when`<LiveData<TvShowEntity>>(local.getBookmarkTvById(tv.id!!)).thenReturn(dummyEntity)

        val courseEntitiesContent = LiveDataTestUtil.getValue(repository.getFavoriteTvById(tv.id!!))
        verify(local).getBookmarkTvById(tv.id!!)
        Assert.assertNotNull(courseEntitiesContent)
        assertEquals(tv.name, courseEntitiesContent?.title)
    }


//    @Test
//    fun getMovieById() {
//        doAnswer { invocation ->
//            (invocation.arguments[0] as RemoteDataSource.LoadMovieByIdCallback).onAllMovieByIdReceived(movDetail)
//            null
//        }.`when`(remote).getMovieDetails(anyInt(), any())
//        val movies = LiveDataTestUtil.getValue(repository.getMovieDetails(movieId!!))
//        verify(remote).getMovieDetails(anyInt(), any())
//
//        assertNotNull(movies)
////        assertNotNull(movies.title)
////        assertEquals(movieResponses[0].title, movies.title)
//
//    }
//
//    @Test
//    fun getTVById() {
//        doAnswer { invocation ->
//            (invocation.arguments[0] as RemoteDataSource.LoadTVByIdCallback).onAllTVByIdReceived(tv)
//            null
//        }.`when`(remote).getAllTVById(any(), anyInt())
//        val tv = LiveDataTestUtil.getValue(repository.getTVById(tvId!!))
//        verify(remote).getAllTVById(any(), anyInt())
//
//        assertNotNull(tv)
//        assertNotNull(tv.name)
//        assertEquals(tvResponses[0].name, tv.name)
//
//    }



//
//    @Test
//    fun getAllMovies() {
//        doAnswer { invocation ->
//            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback).onAllMoviesReceived(movieResponses)
//            null
//        }.`when`(remote).getMoviePopular(1,any())
//        val movies = LiveDataTestUtil.getValue(repository.getMoviePopular(1))
//        verify(remote).getMoviePopular(1, any())
//
//        Assert.assertNotNull(movies)
//        assertEquals(movieResponses.results?.size, movies?.size)
//
//    }

//    @Test
//    fun getAllTV() {
//        doAnswer { invocation ->
//            (invocation.arguments[0] as RemoteDataSource.LoadTVCallback).onAllTVReceived(tvResponses)
//            null
//        }.`when`(remote).getAllTV(any())
//        val tv = LiveDataTestUtil.getValue(repository.getTVshow())
//        verify(remote).getAllTV(any())
//
//        Assert.assertNotNull(tv)
//        assertEquals(tvResponses.size, tv.size)
//
//    }
//
}