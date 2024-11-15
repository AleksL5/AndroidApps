package com.example.mypermissionsapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PhotoDao {
    @Query("SELECT * FROM photos ORDER BY id DESC")
    fun getAllPhotos(): LiveData<List<PhotoEntity>>

    @Insert
    suspend fun insertPhoto(photo: PhotoEntity)
}