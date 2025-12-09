package com.example.birdsofguatemala.network

import com.example.birdsofguatemala.model.BirdResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface XenoCantoApi {

    @GET("api/3/recordings")
    suspend fun getBirds(
        @Query("query") query: String = "cnt:Guatemala",
        @Query("key") apiKey: String = "dc16feccc884b424e592b38cb51bcda8260a44b9"
    ): BirdResponse
}
