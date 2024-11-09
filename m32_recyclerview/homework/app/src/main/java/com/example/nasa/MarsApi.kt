package com.example.nasa

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MarsApi {
    private const val BASE_URL = "https://api.nasa.gov/"

    val retrofitService: MarsApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MarsApiService::class.java)
    }
}