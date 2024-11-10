package com.example.nasa

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MarsPhotoViewModelFactory(
    private val repository: MarsPhotoRepository,
    private val sol: Int
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MarsPhotoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MarsPhotoViewModel(repository, sol) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}