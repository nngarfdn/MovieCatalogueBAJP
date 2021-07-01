//package com.nanangarifudin.moviecatalogue.ui.detail
//
//import androidx.arch.core.executor.testing.InstantTaskExecutorRule
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.Observer
//import com.nanangarifudin.moviecatalogue.data.MovieTVRepository
//import com.nanangarifudin.moviecatalogue.utils.DataDummy
//import com.nhaarman.mockitokotlin2.verify
//import junit.framework.Assert.assertEquals
//import org.junit.Assert
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.mockito.Mock
//import org.mockito.Mockito
//import org.mockito.junit.MockitoJUnitRunner
//
//@RunWith(MockitoJUnitRunner::class)
//class DetailViewModelTest {
//
//    private lateinit var viewModel: DetailViewModel
//    private val dummyMovie = DataDummy.generateDummyMovies()[0]
//    private val dummyTV = DataDummy.generateDummyTvShows()[0]
//
//
//    @get:Rule
//    val instantTaskExecutorRule = InstantTaskExecutorRule()
//
//    @Mock
//    private lateinit var movieTVRepository: MovieTVRepository
//
//    @Mock
//    private lateinit var observerMov: Observer<MovieResponse>
//
//    @Mock
//    private lateinit var observerTV : Observer<TVResponse>
//
//    @Before
//    fun setUp() {
//        viewModel = DetailViewModel(movieTVRepository)
//    }
//
//    @Test
//    fun getMovieById() {
//        val movie = MutableLiveData<MovieResponse>()
//        movie.value = dummyMovie
//
//        Mockito.`when`(dummyMovie.id?.let { movieTVRepository.getMovieById(it) }).thenReturn(movie)
//        val movieData = dummyMovie.id?.let { viewModel.getMovieById(it).value }
//        dummyMovie.id?.let { verify(movieTVRepository).getMovieById(it) }
//
//        Assert.assertNotNull(movieData)
//        assertEquals(dummyMovie, movieData)
//
//        dummyMovie.id?.let { viewModel.getMovieById(it).observeForever(observerMov) }
//        verify(observerMov).onChanged(dummyMovie)
//    }
//
//    @Test
//    fun getTVById() {
//        val tv = MutableLiveData<TVResponse>()
//        tv.value = dummyTV
//
//        Mockito.`when`(dummyTV.id?.let { movieTVRepository.getTVById(it) }).thenReturn(tv)
//        val tvData = dummyTV.id?.let { viewModel.getTVById(it).value }
//        dummyTV.id?.let { verify(movieTVRepository).getTVById(it) }
//
//        Assert.assertNotNull(tvData)
//        assertEquals(dummyTV, tvData)
//
//        dummyTV.id?.let { viewModel.getTVById(it).observeForever(observerTV) }
//        verify(observerTV).onChanged(dummyTV)
//    }
//
//}