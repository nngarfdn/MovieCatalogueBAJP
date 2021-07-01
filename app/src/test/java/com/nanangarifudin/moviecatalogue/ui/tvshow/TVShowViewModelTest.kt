//package com.nanangarifudin.moviecatalogue.ui.tvshow
//
//import androidx.arch.core.executor.testing.InstantTaskExecutorRule
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.Observer
//import com.nanangarifudin.moviecatalogue.data.MovieTVRepository
//import com.nanangarifudin.moviecatalogue.utils.DataDummy
//import com.nhaarman.mockitokotlin2.verify
//import org.junit.Before
//import org.junit.Test
//
//import org.junit.Assert.*
//import org.junit.Rule
//import org.junit.runner.RunWith
//import org.mockito.Mock
//import org.mockito.Mockito
//import org.mockito.junit.MockitoJUnitRunner
//
//
//@RunWith(MockitoJUnitRunner::class)
//class TVShowViewModelTest {
//
//    private lateinit var viewModel: TVShowViewModel
//    private val dummyTV = DataDummy.generateDummyTvShows()
//
//    @get:Rule
//    val instantTaskExecutorRule = InstantTaskExecutorRule()
//
//    @Mock
//    private lateinit var movieTVRepository: MovieTVRepository
//
//    @Mock
//    private lateinit var observer: Observer<List<TVResponse>>
//
//    @Before
//    fun setUp() {
//        viewModel = TVShowViewModel(movieTVRepository)
//        viewModel.getTvShow()
//    }
//
//    @Test
//    fun getTV() {
//        val tvResponse = MutableLiveData<List<TVResponse>>()
//        tvResponse.value = dummyTV
//
//        Mockito.`when`(movieTVRepository.getTVshow()).thenReturn(tvResponse)
//        val tv = viewModel.getTvShow().value
//
//        assertNotNull(tv)
//        assertEquals(dummyTV.size, tv?.size)
//
//        viewModel.getTvShow().observeForever(observer)
//        verify(observer).onChanged(dummyTV)
//    }
//}