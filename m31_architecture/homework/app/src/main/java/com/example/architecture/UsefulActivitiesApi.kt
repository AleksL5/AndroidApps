package com.example.architecture

import retrofit2.http.GET

interface UsefulActivitiesApi {
    @GET("api/activity")
    suspend fun getActivity(): UsefulActivityDto
}