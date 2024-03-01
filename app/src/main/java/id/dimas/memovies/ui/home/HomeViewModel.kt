package id.dimas.memovies.ui.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import id.dimas.memovies.data.repository.HomeRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@HiltViewModel
@ExperimentalCoroutinesApi
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {


    fun getPopularMovies() = homeRepository.getAllPopularMovies()

    fun getNowPlayingMovies() = homeRepository.getAllNowPlayingMovies()

    fun getUpcomingMovies() = homeRepository.getAllUpcomingMovies()


}