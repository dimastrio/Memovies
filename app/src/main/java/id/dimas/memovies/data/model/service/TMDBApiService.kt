package id.dimas.memovies.data.model.service

import id.dimas.memovies.data.model.reponse.MovieNowPlayingResponse
import id.dimas.memovies.data.model.reponse.MoviePopularResponse
import id.dimas.memovies.data.model.reponse.MovieUpcomingResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBApiService {

    @GET("movie/popular")
    suspend fun getAllMoviePopular(@Query("api_key") key: String): MoviePopularResponse

    @GET("movie/now_playing")
    suspend fun getAllMovieNowPlaying(@Query("api_key") key: String): MovieNowPlayingResponse

    @GET("movie/upcoming")
    suspend fun getAllMovieUpcoming(@Query("api_key") key: String): MovieUpcomingResponse


//    @GET("movie/")
//    fun getDetailMovie(@Query("api_key") key: String): Call<DetailItem>

}