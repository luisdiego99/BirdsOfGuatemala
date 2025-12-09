package com.example.birdsofguatemala.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val api: XenoCantoApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://xeno-canto.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(XenoCantoApi::class.java)
    }
}
