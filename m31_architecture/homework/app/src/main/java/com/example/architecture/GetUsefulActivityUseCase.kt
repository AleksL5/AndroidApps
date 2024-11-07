package com.example.architecture


import javax.inject.Inject

class GetUsefulActivityUseCase @Inject constructor(
    private val repository: UsefulActivitiesRepository
) {
    suspend fun execute(): UsefulActivity = repository.getUsefulActivity()
}