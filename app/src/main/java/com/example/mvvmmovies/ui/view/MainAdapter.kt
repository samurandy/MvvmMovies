package com.example.mvvmmovies.ui.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmmovies.databinding.ItemCardBinding
import com.example.mvvmmovies.data.model.Movie
import com.example.mvvmmovies.utils.Extensions.Companion.glide

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    private var movies = mutableListOf<Movie>()

    fun setMovieList(movies: List<Movie>) {
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = ItemCardBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = movies[position]
        holder.binding.name.text = movie.name
        movie.imageUrl?.let { holder.binding.imageview.glide(it) }

        // ClickListener in recycler from Main to Detail
        holder.binding.imageview.setOnClickListener { v ->
            val intent = Intent(v.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_ID, movies[position])
            v.context.startActivity(intent)
        }
    }



    override fun getItemCount(): Int {
        return movies.size
    }
}

class MainViewHolder(val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root)