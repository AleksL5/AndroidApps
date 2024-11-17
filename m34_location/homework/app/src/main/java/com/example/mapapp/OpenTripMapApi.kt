package com.example.mapapp

import retrofit2.http.GET
import retrofit2.http.Query

interface OpenTripMapApi {
    @GET("0.1/ru/places/radius")
    suspend fun getLandmarks(
        @Query("radius") radius: Int,
        @Query("lon") lon: Double,
        @Query("lat") lat: Double,
        @Query("apikey") apiKey: String
    ): LandmarkResponseWrapper


    data class LandmarkResponseWrapper(
        val features: List<LandmarkResponse>
    )

    data class LandmarkResponse(
        val properties: PropertiesResponse,
        val geometry: GeometryResponse
    )

    data class PropertiesResponse(
        val xid: String,
        val name: String?
    )

    data class GeometryResponse(
        val coordinates: List<Double>
    )
}