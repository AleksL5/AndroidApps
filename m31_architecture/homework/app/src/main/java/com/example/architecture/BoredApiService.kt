package com.example.architecture

import retrofit2.http.GET

interface BoredApiService {
    @GET("activity")
    suspend fun getActivity(): UsefulActivityDto
}