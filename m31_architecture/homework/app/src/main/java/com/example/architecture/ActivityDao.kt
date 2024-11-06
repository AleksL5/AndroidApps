package com.example.architecture

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ActivityDao {
    @Insert
    suspend fun insert(activity: UsefulActivityDto)

    @Query("SELECT * FROM activities")
    suspend fun getAllActivities(): List<UsefulActivityDto>
}