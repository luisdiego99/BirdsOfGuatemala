package com.example.birdsofguatemala.data.network

import com.example.birdsofguatemala.data.model.BirdApiResult
import retrofit2.http.GET

interface BirdApiService {

    @GET("recordings?query=cnt:Guatemala&key=dc16feccc884b424e592b38cb51bcda8260a44b9")
    suspend fun getBirds(): BirdApiResult
}
