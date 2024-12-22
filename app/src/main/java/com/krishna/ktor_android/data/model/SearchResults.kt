package com.krishna.ktor_android.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResults(
    @SerialName("description")
    val description: List<Description>? = null,
    @SerialName("error_code")
    val errorCode: Int? = null,
    @SerialName("ok")
    val ok: Boolean = false
) {
    @Serializable
    data class Description(
        @SerialName("#ACTORS")
        val aCTORS: String,
        @SerialName("#AKA")
        val aKA: String,
        @SerialName("#IMDB_ID")
        val iMDBID: String,
        @SerialName("#IMDB_IV")
        val iMDBIV: String,
        @SerialName("#IMDB_URL")
        val iMDBURL: String,
        @SerialName("#IMG_POSTER")
        val iMGPOSTER: String,
        @SerialName("photo_height")
        val photoHeight: Int,
        @SerialName("photo_width")
        val photoWidth: Int,
        @SerialName("#RANK")
        val rANK: Int,
        @SerialName("#TITLE")
        val tITLE: String,
        @SerialName("#YEAR")
        val yEAR: Int
    )
}