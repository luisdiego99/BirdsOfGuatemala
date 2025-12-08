package com.example.birdsofguatemala.data.model

data class BirdApiResult(
    val recordings: List<BirdItem>
)

data class BirdItem(
    val id: String,
    val gen: String,
    val sp: String,
    val grp: String,
    val en: String,
    val rec: String,
    val loc: String,
    val file: String
)
