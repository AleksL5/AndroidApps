package com.example.nasa

data class MarsPhoto(
    val id: Int,
    val img_src: String,
    val earth_date: String
)

data class MarsPhotoResponse(
    val photos: List<MarsPhoto>
)