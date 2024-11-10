package com.example.nasa

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow

class MarsPhotoRepository(
    private val apiService: MarsApiService,
    private val apiKey: String
) {
    fun getMarsPhotos(sol: Int): Flow<PagingData<MarsPhoto>> {
        return Pager(
            config = PagingConfig(pageSize = 25, enablePlaceholders = false),
            pagingSourceFactory = { MarsPhotoPagingSource(apiService, apiKey, sol) } // Передаем sol в PagingSource
        ).flow
    }
}