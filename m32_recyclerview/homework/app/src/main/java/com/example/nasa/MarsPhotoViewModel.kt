package com.example.nasa

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MarsPhotoViewModel(repository: MarsPhotoRepository, sol: Int) : ViewModel() {
    val photos: Flow<PagingData<MarsPhoto>> = repository.getMarsPhotos(sol).cachedIn(viewModelScope)
}