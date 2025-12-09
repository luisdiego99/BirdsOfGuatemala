package com.example.birdsofguatemala.model

import com.google.gson.annotations.SerializedName

data class BirdResponse(
    @SerializedName("recordings") val recordings: List<BirdApiModel>
)

data class BirdApiModel(
    val id: String,
    @SerializedName("en") val commonName: String,
    @SerializedName("gen") val gen: String,
    @SerializedName("sp") val sp: String,
    @SerializedName("loc") val location: String,
    @SerializedName("rec") val recordist: String,
    @SerializedName("file") val audioUrl: String,
    @SerializedName("grp") val grp: String
) {
    fun toBirdItem() = BirdItem(
        id = id,
        commonName = commonName,
        scientificName = "$gen $sp",
        location = location,
        recordist = recordist,
        audioUrl = audioUrl
    )
}
