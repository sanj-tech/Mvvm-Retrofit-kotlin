package com.example.retrofitusingmvvm.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitusingmvvm.databinding.MovieItemBinding
import com.example.retrofitusingmvvm.model.Movies

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {
    var movies = mutableListOf<Movies>()

    fun setMovieList(movies: List<Movies>) {
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MovieItemBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = movies[position]
        holder.binding.name.text= movie.name
        Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.binding.imageview)
    }
    override fun getItemCount(): Int {

        return movies.size
    }
}
class MainViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
}