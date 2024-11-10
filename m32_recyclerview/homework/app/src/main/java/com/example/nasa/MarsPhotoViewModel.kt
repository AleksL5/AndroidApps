package com.example.nasa

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class MarsPhotoViewModel(repository: MarsPhotoRepository, sol: Int) : ViewModel() {
    val photos: Flow<PagingData<MarsPhoto>> = repository.getMarsPhotos(sol).cachedIn(viewModelScope)
}

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
