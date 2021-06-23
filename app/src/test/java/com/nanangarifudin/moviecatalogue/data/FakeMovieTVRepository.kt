package com.nanangarifudin.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nanangarifudin.moviecatalogue.data.remote.RemoteDataSource
import com.nanangarifudin.moviecatalogue.data.source.MovieTVDataSource

class FakeMovieTVRepository (private val remoteDataSource: RemoteDataSource) : MovieTVDataSource  {

    override fun getMovies(): LiveData<List<MovieResponse>> {

        val courseResults = MutableLiveData<List<MovieResponse>>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(movieResponse: List<MovieResponse>) {
                val courseList = ArrayList<MovieResponse>()
                for (response in movieResponse) {
                    val course = MovieResponse(
                            response.adult,
                            response.backdrop_path,
                            response.genre_ids,
                            response.id,
                            response.original_language,
                            response.original_title,
                            response.overview,
                            response.popularity,
                            response.poster_path,
                            response.release_date,
                            response.title,
                            response.video,
                            response.vote_average,
                            response.vote_count,
                    )
                    courseList.add(course)
                }
                courseResults.postValue(courseList)
            }
        })
        return courseResults
    }

    override fun getTVshow(): LiveData<List<TVResponse>> {
        val courseResults = MutableLiveData<List<TVResponse>>()
        remoteDataSource.getAllTV(object : RemoteDataSource.LoadTVCallback {
            override fun onAllTVReceived(movieResponse: List<TVResponse>) {
                val courseList = ArrayList<TVResponse>()
                for (response in movieResponse) {
                    val course = TVResponse(
                            response.backdrop_path,
                            response.first_air_date,
                            response.genre_ids,
                            response.id,
                            response.name,
                            response.origin_country,
                            response.original_language,
                            response.original_name,
                            response.overview,
                            response.popularity,
                            response.poster_path,
                            response.vote_average,
                            response.vote_count,
                    )
                    courseList.add(course)
                }
                courseResults.postValue(courseList)
            }
        })
        return courseResults
    }

    override fun getMovieById(movieId: Int): LiveData<MovieResponse> {
        val courseResults = MutableLiveData<MovieResponse>()
        remoteDataSource.getAllMovieById(object : RemoteDataSource.LoadMovieByIdCallback {
            override fun onAllMovieByIdReceived(movieResponse: MovieResponse) {
                val course = MovieResponse(
                        movieResponse.adult,
                        movieResponse.backdrop_path,
                        movieResponse.genre_ids,
                        movieResponse.id,
                        movieResponse.original_language,
                        movieResponse.original_title,
                        movieResponse.overview,
                        movieResponse.popularity,
                        movieResponse.poster_path,
                        movieResponse.release_date,
                        movieResponse.title,
                        movieResponse.video,
                        movieResponse.vote_average,
                        movieResponse.vote_count,
                )
                courseResults.postValue(course)
            }

        }, movieId)

        return courseResults
    }


    override fun getTVById(movieId: Int): LiveData<TVResponse> {
        val courseResults = MutableLiveData<TVResponse>()
        remoteDataSource.getAllTVById(object : RemoteDataSource.LoadTVByIdCallback{
            override fun onAllTVByIdReceived(tvResponse: TVResponse) {
                val course = TVResponse(
                        tvResponse.backdrop_path,
                        tvResponse.first_air_date,
                        tvResponse.genre_ids,
                        tvResponse.id,
                        tvResponse.name,
                        tvResponse.origin_country,
                        tvResponse.original_language,
                        tvResponse.original_name,
                        tvResponse.overview,
                        tvResponse.popularity,
                        tvResponse.poster_path,
                        tvResponse.vote_average,
                        tvResponse.vote_count,
                )
                courseResults.postValue(course)
            }

        }, movieId)

        return courseResults
    }

}