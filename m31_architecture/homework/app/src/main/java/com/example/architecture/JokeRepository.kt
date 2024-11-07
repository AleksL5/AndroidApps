package com.example.architecture

import javax.inject.Inject

class JokeRepository @Inject constructor(
    private val api: JokeApi
) {
    suspend fun getRandomJoke(): Joke {
        return api.getRandomJoke()
    }
}