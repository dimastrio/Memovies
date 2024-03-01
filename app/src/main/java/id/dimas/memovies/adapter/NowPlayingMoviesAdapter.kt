package id.dimas.memovies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.dimas.memovies.data.model.reponse.MovieNowPlaying
import id.dimas.memovies.databinding.ItemMovieBinding

class NowPlayingMoviesAdapter(private val onClick: (MovieNowPlaying) -> Unit) :
    RecyclerView.Adapter<NowPlayingMoviesAdapter.NowPlayingMoviesViewHolder>() {


    private val diffCallback = object : DiffUtil.ItemCallback<MovieNowPlaying>() {
        override fun areItemsTheSame(oldItem: MovieNowPlaying, newItem: MovieNowPlaying): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: MovieNowPlaying,
            newItem: MovieNowPlaying
        ): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    fun updateData(popularMovies: List<MovieNowPlaying>) = differ.submitList(popularMovies)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowPlayingMoviesViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NowPlayingMoviesViewHolder(binding)
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: NowPlayingMoviesViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    inner class NowPlayingMoviesViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(itemMovieBinding: MovieNowPlaying) {
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

