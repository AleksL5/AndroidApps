package com.example.mydatabinding

import kotlinx.coroutines.delay

class Repository {
    suspend fun getData(): String?{
        delay(5000)
        return listOf(null, "Идёт поиск...").random()
    }
}