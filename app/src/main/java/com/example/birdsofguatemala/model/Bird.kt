package com.example.birdsofguatemala.model

data class Bird(
    val commonName: String,
    val scientificName: String,
    val location: String?,
    val recordist: String?,
    val audioUrl: String?
)
