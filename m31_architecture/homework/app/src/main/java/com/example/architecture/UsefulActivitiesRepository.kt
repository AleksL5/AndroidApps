package com.example.architecture

import javax.inject.Inject

class UsefulActivitiesRepository @Inject constructor(
    private val api: UsefulActivitiesApi
) {
    suspend fun getUsefulActivity(): UsefulActivityDto {
        return api.getActivity()
    }
}