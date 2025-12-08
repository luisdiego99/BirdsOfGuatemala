package com.example.birdsofguatemala.data.repository

import com.example.birdsofguatemala.data.network.BirdApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BirdRepository {

    private val api = Retrofit.Builder()
        .baseUrl("https://xeno-canto.org/api/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(BirdApiService::class.java)

    suspend fun loadBirds() =
        api.getBirds().recordings.filter { it.grp == "birds" }
}
