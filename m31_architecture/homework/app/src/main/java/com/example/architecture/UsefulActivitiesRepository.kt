package com.example.architecture

import kotlinx.coroutines.flow.Flow

interface UsefulActivitiesRepository {
    suspend fun getUsefulActivity(): UsefulActivityDto
    suspend fun saveUsefulActivity(activity: UsefulActivityDto)
    suspend fun getAllSavedActivities(): List<UsefulActivityDto>
}