package com.example.movie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.databinding.ItemMovieBinding
import com.example.movie.model.ContentItem
import com.example.movie.extensions.loadUrl


class MoviePagerAdapter :
    PagingDataAdapter<ContentItem, MoviePagerAdapter.MovieViewHolder>(MovieComparator) {

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)!!
        holder.view.tvName.text = movie.name
        holder.view.imgMovie.loadUrl(movie.posterImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    class MovieViewHolder(val view: ItemMovieBinding) : RecyclerView.ViewHolder(view.root)

    object MovieComparator : DiffUtil.ItemCallback<ContentItem>() {
        override fun areItemsTheSame(oldItem: ContentItem, newItem: ContentItem): Boolean {
            // Id is unique.
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: ContentItem, newItem: ContentItem): Boolean {
            return oldItem == newItem
        }
    }
}

