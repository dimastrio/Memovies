package id.dimas.memovies.data.repositoryImpl

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import id.dimas.memovies.BuildConfig
import id.dimas.memovies.data.model.reponse.MovieNowPlaying
import id.dimas.memovies.data.model.reponse.MoviePopular
import id.dimas.memovies.data.model.reponse.MovieUpcoming
import id.dimas.memovies.data.model.service.TMDBApiService
import id.dimas.memovies.data.repository.HomeRepository
import id.dimas.memovies.util.Result
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val apiService: TMDBApiService
) : HomeRepository {


    override fun getAllPopularMovies(): LiveData<Result<List<MoviePopular>>> = liveData {
        emit(Result.Loading())
        try {

            val result = apiService.getAllMoviePopular(BuildConfig.API_KEY).results

            emit(Result.Success(result))

        } catch (e: Exception) {
            emit(Result.Error("Error"))
        }
    }

    override fun getAllNowPlayingMovies(): LiveData<Result<List<MovieNowPlaying>>> = liveData {
        emit(Result.Loading())
        try {

            val result = apiService.getAllMovieNowPlaying(BuildConfig.API_KEY).results

            emit(Result.Success(result))

        } catch (e: Exception) {
            emit(Result.Error("Error"))
        }
    }

    override fun getAllUpcomingMovies(): LiveData<Result<List<MovieUpcoming>>> = liveData {
        emit(Result.Loading())
        try {

            val result = apiService.getAllMovieUpcoming(BuildConfig.API_KEY).results

            emit(Result.Success(result))

        } catch (e: Exception) {
            emit(Result.Error("Error"))
        }
    }
}