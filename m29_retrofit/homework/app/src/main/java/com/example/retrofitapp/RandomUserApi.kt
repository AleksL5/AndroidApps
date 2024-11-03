package com.example.retrofitapp

import retrofit2.Call
import retrofit2.http.GET

interface RandomUserApi {
    @GET("api/")
    fun getRandomUser(): Call<ResponseData>
}

data class ResponseData(val results: List<User>)