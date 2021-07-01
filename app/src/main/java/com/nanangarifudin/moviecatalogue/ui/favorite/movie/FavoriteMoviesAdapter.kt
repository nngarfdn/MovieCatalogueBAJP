package com.nanangarifudin.moviecatalogue.ui.favorite.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nanangarifudin.moviecatalogue.R
import com.nanangarifudin.moviecatalogue.data.local.MovieEntity
import com.nanangarifudin.moviecatalogue.data.remote.response.MovieItem
import com.nanangarifudin.moviecatalogue.data.remote.response.MovieResponse
import com.nanangarifudin.moviecatalogue.ui.detail.DetailActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movies_tv.view.*


class FavoriteMoviesAdapter :
    PagedListAdapter<MovieEntity, FavoriteMoviesAdapter.ViewHolder>(DIFF_CALLBACK)  {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    private lateinit var cardList: List<MovieEntity>

    fun setData(cardList: List<MovieEntity>){
        this.cardList = cardList
    }

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val name: TextView = v.txtTitle
        val photo: ImageView = v.imgPoster
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
                LayoutInflater.from(parent.context).inflate(R.layout.item_movies_tv, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = cardList[position]

        holder.name.text = currentItem.title

        val url = "https://image.tmdb.org/t/p/w600_and_h900_bestv2${currentItem.poster}"
        Picasso.get()
                .load(url)
                .fit()
                .centerCrop()
                .into(holder.photo)


        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_MOVIES, currentItem.id)
            holder.itemView.context.startActivity(intent)
        }
    }
}