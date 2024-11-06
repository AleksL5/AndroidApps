package com.example.architecture

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UsefulActivityDto::class], version = 1)
abstract class ActivityDatabase : RoomDatabase() {
    abstract fun activityDao(): ActivityDao
}