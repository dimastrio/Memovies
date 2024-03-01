package id.dimas.memovies.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import id.dimas.memovies.adapter.NowPlayingMoviesAdapter
import id.dimas.memovies.adapter.PopularMoviesAdapter
import id.dimas.memovies.adapter.UpcomingMoviesAdapter
import id.dimas.memovies.data.model.reponse.MovieNowPlaying
import id.dimas.memovies.data.model.reponse.MoviePopular
import id.dimas.memovies.data.model.reponse.MovieUpcoming
import id.dimas.memovies.databinding.FragmentHomeBinding
import id.dimas.memovies.util.Result
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by viewModels()

    private val popularAdapter by lazy { PopularMoviesAdapter(::onPopularMovieClicked) }
    private val nowPlayingAdapter by lazy { NowPlayingMoviesAdapter(::onNowPlayingMovieClicked) }
    private val upcomingAdapter by lazy { UpcomingMoviesAdapter(::onUpcomingMovieClicked) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.populerMovie.rvMovie.adapter = popularAdapter
        binding.populerMovie.rvMovie.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        observePopularMovies()

        binding.nowPlayingMovie.rvMovie.adapter = nowPlayingAdapter
        binding.nowPlayingMovie.rvMovie.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        observeNowPlaying()

        binding.upcomingMovie.rvMovie.adapter = upcomingAdapter
        binding.upcomingMovie.rvMovie.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        observeUpcoming()

    }

    private fun observePopularMovies() {
        homeViewModel.getPopularMovies().observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Loading -> {

                }

                is Result.Success -> {
                    if (result.data != null) {
                        popularAdapter.updateData(result.data)
                    }
                }

                is Result.Error -> {

                }

            }
        }
    }

    private fun observeNowPlaying() {
        homeViewModel.getNowPlayingMovies().observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Loading -> {

                }

                is Result.Success -> {
                    if (result.data != null) {
                        nowPlayingAdapter.updateData(result.data)
                    }
                }

                is Result.Error -> {

                }


            }
        }

    }

    private fun observeUpcoming() {
        homeViewModel.getUpcomingMovies().observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Loading -> {

                }

                is Result.Success -> {
                    if (result.data != null) {
                        upcomingAdapter.updateData(result.data)
                    }
                }

                is Result.Error -> {

                }


            }
        }

    }


    private fun onPopularMovieClicked(moviePopular: MoviePopular) {

    }

    private fun onNowPlayingMovieClicked(movieNowPlaying: MovieNowPlaying) {

    }

    private fun onUpcomingMovieClicked(movieNowPlaying: MovieUpcoming) {

    }


}