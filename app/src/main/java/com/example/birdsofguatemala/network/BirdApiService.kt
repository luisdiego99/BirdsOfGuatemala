package com.example.birdsofguatemala.network

import com.example.birdsofguatemala.model.BirdResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BirdApiService {
    @GET("/api/2/recordings")
    suspend fun getBirds(@Query("query") query: String = "q:guatemala"): BirdResponse
}
