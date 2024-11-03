package com.example.retrofitapp

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    fun fetchRandomUser(callback: (User?) -> Unit) {
        RetrofitInstance.api.getRandomUser().enqueue(object : Callback<ResponseData> {
            override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                callback(response.body()?.results?.firstOrNull())
            }

            override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                callback(null)
            }
        })
    }
}