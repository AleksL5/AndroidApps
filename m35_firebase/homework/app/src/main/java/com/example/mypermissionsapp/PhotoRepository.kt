package com.example.mypermissionsapp

import androidx.lifecycle.LiveData

class PhotoRepository(private val photoDao: PhotoDao) {
    val allPhotos: LiveData<List<PhotoEntity>> = photoDao.getAllPhotos()

    suspend fun insert(photo: PhotoEntity) {
        photoDao.insertPhoto(photo)
    }
}