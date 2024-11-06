package com.example.architecture


import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UsefulActivitiesRepositoryImpl @Inject constructor(
    private val apiService: BoredApiService,
    private val activityDao: ActivityDao
) : UsefulActivitiesRepository {

    override suspend fun getUsefulActivity(): UsefulActivityDto {
        val activity = try {
            apiService.getActivity()
        } catch (e: Exception) {
            throw Exception("API request failed: ${e.message}")
        }
        activityDao.insert(activity)
        return activity
    }

    override suspend fun saveUsefulActivity(activity: UsefulActivityDto) {
        activityDao.insert(activity)
    }

    override suspend fun getAllSavedActivities(): List<UsefulActivityDto> {
        return activityDao.getAllActivities()
    }
}