package com.nanangarifudin.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nanangarifudin.moviecatalogue.data.remote.RemoteDataSource
import com.nanangarifudin.moviecatalogue.data.remote.response.MovieDetailResponse
import com.nanangarifudin.moviecatalogue.data.remote.response.MovieItem
import com.nanangarifudin.moviecatalogue.data.remote.response.MovieResponse
import com.nanangarifudin.moviecatalogue.data.remote.response.TVResponse
import com.nanangarifudin.moviecatalogue.data.source.MovieTVDataSource

class MovieTVRepository private constructor(private val remoteDataSource: RemoteDataSource) : MovieTVDataSource  {

    companion object {
        @Volatile
        private var instance: MovieTVRepository? = null
        fun getInstance(remoteData: RemoteDataSource): MovieTVRepository =
            instance ?: synchronized(this) {
                instance ?: MovieTVRepository(remoteData).apply { instance = this }
            }
    }

    override fun getMovies(): LiveData<List<MovieResponse>> {
        val courseResults = MutableLiveData<List<MovieResponse>>()
        remoteDataSource.getMoviePopular(1, object : RemoteDataSource.LoadMoviesCallback {

            override fun onAllMoviesReceived(movieResponse: MovieResponse) {
                val courseList = ArrayList<MovieResponse>()
//                for (response in movieResponse) {
//                    val course = MovieResponse(
//                        response.adult,
//                        response.backdrop_path,
//                        response.genre_ids,
//                        response.id,
//                        response.original_language,
//                        response.original_title,
//                        response.overview,
//                        response.popularity,
//                        response.poster_path,
//                        response.release_date,
//                        response.title,
//                        response.video,
//                        response.vote_average,
//                        response.vote_count,
//                    )
//                    courseList.add(course)
//                }
//                courseResults.postValue(courseList)
            }
        })
        return courseResults
    }

    override fun getTVshow(): LiveData<List<TVResponse>> {
        TODO("Not yet implemented")
    }

    override fun getMovieById(movieId: Int): LiveData<MovieResponse> {
        TODO("Not yet implemented")
    }

    override fun getTVById(movieId: Int): LiveData<TVResponse> {
        TODO("Not yet implemented")
    }

    override fun getMovieDetails(movieId: Int): MutableLiveData<MovieDetailResponse> {
        val result: MutableLiveData<MovieDetailResponse> = MutableLiveData<MovieDetailResponse>()
        remoteDataSource.getMovieDetails(movieId, object : RemoteDataSource.LoadMovieByIdCallback{
            override fun onAllMovieByIdReceived(movieResponse: MovieDetailResponse) {
                var mov = movieResponse
                result.postValue(mov)
            }

        })
        return result
    }

    override fun getMoviePopular(page: Int): MutableLiveData<List<MovieItem>> {
        val courseResults = MutableLiveData<List<MovieItem>>()
        remoteDataSource.getMoviePopular(1, object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(movieResponse: MovieResponse) {
                var courseList = movieResponse.results
                courseResults.postValue(courseList!!)
            }
        })
        return courseResults
    }


//    override fun getMovies(): LiveData<List<MovieResponse>> {
//
//        val courseResults = MutableLiveData<List<MovieResponse>>()
//        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback {
//            override fun onAllMoviesReceived(movieResponse: List<MovieResponse>) {
//                val courseList = ArrayList<MovieResponse>()
//                for (response in movieResponse) {
//                    val course = MovieResponse(
//                        response.adult,
//                        response.backdrop_path,
//                        response.genre_ids,
//                        response.id,
//                        response.original_language,
//                        response.original_title,
//                        response.overview,
//                        response.popularity,
//                        response.poster_path,
//                        response.release_date,
//                        response.title,
//                        response.video,
//                        response.vote_average,
//                        response.vote_count,
//                    )
//                    courseList.add(course)
//                }
//                courseResults.postValue(courseList)
//            }
//        })
//        return courseResults
//    }
//
//    override fun getTVshow(): LiveData<List<TVResponse>> {
//        val courseResults = MutableLiveData<List<TVResponse>>()
//        remoteDataSource.getAllTV(object : RemoteDataSource.LoadTVCallback {
//            override fun onAllTVReceived(movieResponse: List<TVResponse>) {
//                val courseList = ArrayList<TVResponse>()
//                for (response in movieResponse) {
//                    val course = TVResponse(
//                            response.backdrop_path,
//                            response.first_air_date,
//                            response.genre_ids,
//                            response.id,
//                            response.name,
//                            response.origin_country,
//                            response.original_language,
//                            response.original_name,
//                            response.overview,
//                            response.popularity,
//                            response.poster_path,
//                            response.vote_average,
//                            response.vote_count,
//                    )
//                    courseList.add(course)
//                }
//                courseResults.postValue(courseList)
//            }
//        })
//        return courseResults
//    }
//
//    override fun getMovieById(movieId: Int): LiveData<MovieResponse> {
//        val courseResults = MutableLiveData<MovieResponse>()
//        remoteDataSource.getAllMovieById(object : RemoteDataSource.LoadMovieByIdCallback {
//            override fun onAllMovieByIdReceived(movieResponse: MovieResponse) {
//                val course = MovieResponse(
//                        movieResponse.adult,
//                        movieResponse.backdrop_path,
//                        movieResponse.genre_ids,
//                        movieResponse.id,
//                        movieResponse.original_language,
//                        movieResponse.original_title,
//                        movieResponse.overview,
//                        movieResponse.popularity,
//                        movieResponse.poster_path,
//                        movieResponse.release_date,
//                        movieResponse.title,
//                        movieResponse.video,
//                        movieResponse.vote_average,
//                        movieResponse.vote_count,
//                )
//                courseResults.postValue(course)
//            }
//
//        }, movieId)
//
//        return courseResults
//    }
//
//
//    override fun getTVById(movieId: Int): LiveData<TVResponse> {
//        val courseResults = MutableLiveData<TVResponse>()
//        remoteDataSource.getAllTVById(object : RemoteDataSource.LoadTVByIdCallback{
//            override fun onAllTVByIdReceived(tvResponse: TVResponse) {
//                val course = TVResponse(
//                        tvResponse.backdrop_path,
//                        tvResponse.first_air_date,
//                        tvResponse.genre_ids,
//                        tvResponse.id,
//                        tvResponse.name,
//                        tvResponse.origin_country,
//                        tvResponse.original_language,
//                        tvResponse.original_name,
//                        tvResponse.overview,
//                        tvResponse.popularity,
//                        tvResponse.poster_path,
//                        tvResponse.vote_average,
//                        tvResponse.vote_count,
//                )
//                courseResults.postValue(course)
//            }
//
//        }, movieId)
//
//        return courseResults
//    }

}