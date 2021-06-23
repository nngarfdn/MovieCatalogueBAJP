package com.nanangarifudin.moviecatalogue.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import com.nanangarifudin.moviecatalogue.R
import com.nanangarifudin.moviecatalogue.viewmodel.ViewModelFactory
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIES = "extra_movies"
        const val EXTRA_TVSHOW = "extra_tvshow"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val extrasMovie = intent.extras?.getInt(EXTRA_MOVIES)
//        val extrasTvShow = intent.extras?.getParcelable<TVResponse>(EXTRA_TVSHOW)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        progress_bar.visibility = View.VISIBLE

        if (extrasMovie != null) {
            viewModel.getMovieById(extrasMovie).observe(this) { movies ->
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

        }

//
//        } else if (extrasTvShow != null){
//            extrasTvShow.id?.let {
//                viewModel.getTVById(it).observe(this, { tv ->
//                    progress_bar.visibility = View.GONE
//                    val url = "https://image.tmdb.org/t/p/w600_and_h900_bestv2${tv.poster_path}"
//                    Picasso.get()
//                            .load(url)
//                            .fit()
//                            .centerCrop()
//                            .into(imgDetail)
//                    txtTitleDetail.text = tv.name
//                    txtDescriptionDetail.text = tv.overview
//                })
//            }
//        }
//        imgShare.setOnClickListener { share() }
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