package id.dimas.memovies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.dimas.memovies.data.model.reponse.MovieUpcoming
import id.dimas.memovies.databinding.ItemMovieBinding

class UpcomingMoviesAdapter(private val onClick: (MovieUpcoming) -> Unit) :
    RecyclerView.Adapter<UpcomingMoviesAdapter.UpcomingMoviesViewHolder>() {


    private val diffCallback = object : DiffUtil.ItemCallback<MovieUpcoming>() {
        override fun areItemsTheSame(oldItem: MovieUpcoming, newItem: MovieUpcoming): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MovieUpcoming, newItem: MovieUpcoming): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    fun updateData(popularMovies: List<MovieUpcoming>) = differ.submitList(popularMovies)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingMoviesViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UpcomingMoviesViewHolder(binding)
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: UpcomingMoviesViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    inner class UpcomingMoviesViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(itemMovieBinding: MovieUpcoming) {
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

