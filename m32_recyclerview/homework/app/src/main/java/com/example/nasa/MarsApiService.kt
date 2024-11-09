package com.example.nasa

import retrofit2.http.GET
import retrofit2.http.Query

interface MarsApiService {
    @GET("mars-photos/api/v1/rovers/curiosity/photos")
    suspend fun getPhotos(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): MarsPhotoResponse
}