package com.nanangarifudin.moviecatalogue.utils

import android.content.Context
import com.nanangarifudin.moviecatalogue.data.remote.response.MovieItem
import com.nanangarifudin.moviecatalogue.data.remote.response.MovieResponse
import com.nanangarifudin.moviecatalogue.data.remote.response.TVResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(fileName: String): List<MovieItem> {
        val list = ArrayList<MovieItem>()
        try {
            val responseObject = JSONObject(parsingFileToString(fileName).toString())
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()) {
                val course = listArray.getJSONObject(i)
                val adult = course.getString("adult").toBoolean()
                val backdrop_path = course.getString("backdrop_path")
                val id = course.getString("id").toInt()
                val original_language = course.getString("original_language")
                val original_title = course.getString("original_title")
                val overview = course.getString("overview")
                val popularity = course.getString("popularity").toDouble()
                val poster_path = course.getString("poster_path")
                val release_date = course.getString("release_date")
                val title = course.getString("title")
                val video = course.getString("video").toBoolean()
                val vote_average = course.getString("vote_average").toDouble()
                val vote_count = course.getString("vote_count").toInt()
                val movie = MovieItem(adult,backdrop_path,null,id,original_language,original_title, overview,popularity,
                poster_path, release_date, title,video,vote_average,vote_count)

                list.add(movie)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }


//    fun loadMoviesById(fileName: String, movieId : Int): MovieResponse {
//        val list = ArrayList<MovieResponse>()
//        try {
//            val responseObject = JSONObject(parsingFileToString(fileName).toString())
//            val listArray = responseObject.getJSONArray("results")
//            for (i in 0 until listArray.length()) {
//                val course = listArray.getJSONObject(i)
//                val idMov = course.getString("id").toInt()
//                if (idMov == movieId){
//                    val adult = course.getString("adult").toBoolean()
//                    val backdrop_path = course.getString("backdrop_path")
//                    val id = course.getString("id").toInt()
//                    val original_language = course.getString("original_language")
//                    val original_title = course.getString("original_title")
//                    val overview = course.getString("overview")
//                    val popularity = course.getString("popularity").toDouble()
//                    val poster_path = course.getString("poster_path")
//                    val release_date = course.getString("release_date")
//                    val title = course.getString("title")
//                    val video = course.getString("video").toBoolean()
//                    val vote_average = course.getString("vote_average").toDouble()
//                    val vote_count = course.getString("vote_count").toInt()
//                    val movie = MovieResponse(adult,backdrop_path,null,id,original_language,original_title, overview,popularity,
//                            poster_path, release_date, title,video,vote_average,vote_count)
//                    list.add(movie)
//                }
//
//            }
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//
//        return list[0] as MovieResponse
//    }

//    fun loadTVs(fileName: String): List<TVResponse> {
//        var list = ArrayList<TVResponse>()
//        try {
//            val responseObject = JSONObject(parsingFileToString(fileName).toString())
//            val listArray = responseObject.getJSONArray("results")
//            for (i in 0 until listArray.length()) {
//                val course = listArray.getJSONObject(i)
//
//                val backdrop_path = course.getString("backdrop_path")
//                val first_air_date = course.getString("first_air_date")
//                val id = course.getString("id").toInt()
//                val name = course.getString("name")
//                val original_language = course.getString("original_language")
//                val original_name = course.getString("original_name")
//                val overview = course.getString("overview")
//                val popularity = course.getString("popularity").toDouble()
//                val poster_path = course.getString("poster_path")
//                val vote_average = course.getString("vote_average").toDouble()
//                val vote_count = course.getString("vote_count").toInt()
//                val tv = TVResponse(backdrop_path,first_air_date,null,id,name,null,
//                    original_language,original_name, overview, popularity, poster_path,vote_average,vote_count)
//
//                list.add(tv)
//            }
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//
//        return list
//    }
//
//    fun loadTVById(fileName: String, tvId : Int): TVResponse {
//        var list = ArrayList<TVResponse>()
//        try {
//            val responseObject = JSONObject(parsingFileToString(fileName).toString())
//            val listArray = responseObject.getJSONArray("results")
//            for (i in 0 until listArray.length()) {
//                val course = listArray.getJSONObject(i)
//                val idTv = course.getString("id").toInt()
//                if (idTv == tvId){
//                    val backdrop_path = course.getString("backdrop_path")
//                    val first_air_date = course.getString("first_air_date")
//                    val id = course.getString("id").toInt()
//                    val name = course.getString("name")
//                    val original_language = course.getString("original_language")
//                    val original_name = course.getString("original_name")
//                    val overview = course.getString("overview")
//                    val popularity = course.getString("popularity").toDouble()
//                    val poster_path = course.getString("poster_path")
//                    val vote_average = course.getString("vote_average").toDouble()
//                    val vote_count = course.getString("vote_count").toInt()
//                    val tv = TVResponse(backdrop_path,first_air_date,null,id,name,null,
//                            original_language,original_name, overview, popularity, poster_path,vote_average,vote_count)
//
//                    list.add(tv)
//                }
//            }
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//
//        return list[0]
//    }


}