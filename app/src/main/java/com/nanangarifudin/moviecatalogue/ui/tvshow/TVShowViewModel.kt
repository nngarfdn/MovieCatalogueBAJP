package com.nanangarifudin.moviecatalogue.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nanangarifudin.moviecatalogue.data.MovieTVRepository
import com.nanangarifudin.moviecatalogue.data.remote.response.TVItem
import com.nanangarifudin.moviecatalogue.data.remote.response.TVResponse

class TVShowViewModel (private val repository : MovieTVRepository) : ViewModel() {

    fun getTvShow(): MutableLiveData<List<TVItem>> = repository.getTvPopular(1)

}