package id.dimas.memovies.data.model.reponse


import com.google.gson.annotations.SerializedName

data class MovieUpcomingResponse(
    @SerializedName("dates")
    val dates: Dates,
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<MovieUpcoming>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)