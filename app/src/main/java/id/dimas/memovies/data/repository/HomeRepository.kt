package id.dimas.memovies.data.repository

import androidx.lifecycle.LiveData
import id.dimas.memovies.data.model.reponse.MovieNowPlaying
import id.dimas.memovies.data.model.reponse.MoviePopular
import id.dimas.memovies.data.model.reponse.MovieUpcoming
import id.dimas.memovies.util.Result


interface HomeRepository {

    fun getAllPopularMovies(): LiveData<Result<List<MoviePopular>>>

    fun getAllNowPlayingMovies(): LiveData<Result<List<MovieNowPlaying>>>

    fun getAllUpcomingMovies(): LiveData<Result<List<MovieUpcoming>>>

}