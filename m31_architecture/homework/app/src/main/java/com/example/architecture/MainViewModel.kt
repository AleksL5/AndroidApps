package com.example.architecture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class UiState {
    object Loading : UiState()
    data class Success(val activity: UsefulActivityDto) : UiState()
    data class Error(val message: String) : UiState()
}

class MainViewModel @Inject constructor(
    private val getUsefulActivityUseCase: GetUsefulActivityUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> get() = _uiState

    fun reloadUsefulActivity() {
        _uiState.value = UiState.Loading
        viewModelScope.launch {
            try {
                val activity = getUsefulActivityUseCase.execute()
                _uiState.value = UiState.Success(activity)
            } catch (e: Exception) {
                _uiState.value = UiState.Error("Failed to load activity")
            }
        }
    }
}
