package com.nanangarifudin.moviecatalogue.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import com.nanangarifudin.moviecatalogue.R
import com.nanangarifudin.moviecatalogue.data.local.MovieEntity
import com.nanangarifudin.moviecatalogue.data.local.TvShowEntity
import com.nanangarifudin.moviecatalogue.data.remote.response.MovieDetailResponse
import com.nanangarifudin.moviecatalogue.data.remote.response.MovieItem
import com.nanangarifudin.moviecatalogue.data.remote.response.TVDetailResponse
import com.nanangarifudin.moviecatalogue.viewmodel.ViewModelFactory
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlin.math.log

class DetailActivity : AppCompatActivity() {

    private var movie : MovieDetailResponse? = null
    private var isFavorite : Boolean = false

    companion object {
        const val EXTRA_MOVIES = "extra_movies"
        const val EXTRA_TVSHOW = "extra_tvshow"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val extrasMovie = intent.extras?.getInt(EXTRA_MOVIES)


        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        progress_bar.visibility = View.VISIBLE


        if (extrasMovie != null && extrasMovie!= 0) {
            viewModel.getMovieById(extrasMovie).observe(this) { movies ->
                Log.d("detail", "onCreate: ${movies.title}")
                movie = movies
                progress_bar.visibility = View.GONE
                val url = "https://image.tmdb.org/t/p/w600_and_h900_bestv2${movies.posterPath}"
                Picasso.get()
                    .load(url)
                    .fit()
                    .centerCrop()
                    .into(imgDetail)
                txtTitleDetail.text = movies.title
                txtDescriptionDetail.text = movies.overview

            }
            viewModel.getFavoriteById(extrasMovie).observe(this) { fav ->
                isFavorite = fav != null
                setFavoriteView()
                Log.d("apakah favorit ?", "onCreate: $isFavorite")
            }
            imgFavorite.setOnClickListener {
                Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show()
                if (isFavorite){
                    movie?.id?.let { it1 -> viewModel.deletefavorite(it1) }
                    isFavorite = false
                } else {
                    val mov = MovieEntity(
                        movie?.id, movie?.title, movie?.overview, true, movie?.posterPath
                    )
                    isFavorite = true
                    viewModel.insertfavorite(mov)
                }
            }
            imgShare.setOnClickListener { share() }
        }
        else {
            val extrasTvShow = intent.extras?.getInt(EXTRA_TVSHOW)
            var tv : TVDetailResponse? = null
            if (extrasTvShow!= null && extrasTvShow != 0){
                viewModel.getTvById(extrasTvShow).observe(this) { movies ->
                    Log.d("detail", "onCreate: ${movies.name}")
                    tv = movies
                    progress_bar.visibility = View.GONE
                    val url = "https://image.tmdb.org/t/p/w600_and_h900_bestv2${movies.posterPath}"
                    Picasso.get()
                        .load(url)
                        .fit()
                        .centerCrop()
                        .into(imgDetail)
                    txtTitleDetail.text = movies.name
                    txtDescriptionDetail.text = movies.overview

                }
                viewModel.getFavoriteTvById(extrasTvShow).observe(this) { fav ->
                    isFavorite = fav != null
                    setFavoriteView()
                    Log.d("apakah favorit ?", "onCreate: $isFavorite")
                }
                imgFavorite.setOnClickListener {
                    Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show()
                    if (isFavorite){
                        tv?.id?.let { it1 -> viewModel.deletefavoriteTv(it1) }
                        isFavorite = false
                    } else {
                        val mov = TvShowEntity(
                            tv?.id, tv?.name, tv?.overview, true, tv?.posterPath
                        )
                        isFavorite = true
                        viewModel.insertfavoriteTv(mov)
                    }
                }
                imgShare.setOnClickListener { share() }
            }

        }
    }

    private fun setFavoriteView() {
        if (isFavorite) {
            imgFavorite.setImageResource(R.drawable.ic_baseline_favorite_red)
        } else {
            imgFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        }
    }

    private fun share() {
        val title = txtTitleDetail.text.toString()
        val description = txtDescriptionDetail.text.toString()
        val share = "$title\n$description"
        ShareCompat.IntentBuilder
            .from(this).setChooserTitle("Share :")
            .setText(share).setType("text/plain")
            .startChooser()
    }

}