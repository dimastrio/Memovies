package id.dimas.memovies.data.model.reponse


import com.google.gson.annotations.SerializedName

data class MoviePopularResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<MoviePopular>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)