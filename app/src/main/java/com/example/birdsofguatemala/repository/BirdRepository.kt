package com.example.birdsofguatemala.repository

import com.example.birdsofguatemala.model.BirdItem
import com.example.birdsofguatemala.network.RetrofitClient

class BirdRepository {
    suspend fun fetchBirds(): List<BirdItem> {
        return try {
            RetrofitClient.api.getBirds().recordings
                .filter { it.grp?.lowercase() == "birds" }
                .map { it.toBirdItem() }
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}
