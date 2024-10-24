package com.example.databinding

import kotlinx.coroutines.delay

class Repository {
    suspend fun getData(): String?{
        delay(5000)
        return listOf(null, "Результат поиска...").random()
    }
}