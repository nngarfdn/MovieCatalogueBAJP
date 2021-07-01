package com.nanangarifudin.moviecatalogue.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nanangarifudin.moviecatalogue.R
import com.nanangarifudin.moviecatalogue.data.remote.response.TVItem
import com.nanangarifudin.moviecatalogue.data.remote.response.TVResponse
import com.nanangarifudin.moviecatalogue.ui.detail.DetailActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movies_tv.view.*

class TvShowAdapter :
    RecyclerView.Adapter<TvShowAdapter.ViewHolder>() {

    private lateinit var cardList: List<TVItem>

    fun setData(cardList: List<TVItem>) {
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

        holder.name.text = currentItem.name

        val url = "https://image.tmdb.org/t/p/w600_and_h900_bestv2${currentItem.posterPath}"
        Picasso.get()
            .load(url)
            .fit()
            .centerCrop()
            .into(holder.photo)


        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_TVSHOW, currentItem.id)
            holder.itemView.context.startActivity(intent)
        }
    }
}