package id.dimas.memovies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.dimas.memovies.data.model.reponse.MoviePopular
import id.dimas.memovies.databinding.ItemMovieBinding

class PopularMoviesAdapter(private val onClick: (MoviePopular) -> Unit) :
    RecyclerView.Adapter<PopularMoviesAdapter.PopularMoviesViewHolder>() {


    private val diffCallback = object : DiffUtil.ItemCallback<MoviePopular>() {
        override fun areItemsTheSame(oldItem: MoviePopular, newItem: MoviePopular): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MoviePopular, newItem: MoviePopular): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    fun updateData(popularMovies: List<MoviePopular>) = differ.submitList(popularMovies)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMoviesViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularMoviesViewHolder(binding)
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: PopularMoviesViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    inner class PopularMoviesViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(itemMovieBinding: MoviePopular) {
            binding.apply {
                tvMovieTitle.text = itemMovieBinding.title
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500${itemMovieBinding.posterPath}")
                    .into(ivMovie)
                itemView.setOnClickListener {
                    onClick(itemMovieBinding)
                }

            }
        }

    }

}

