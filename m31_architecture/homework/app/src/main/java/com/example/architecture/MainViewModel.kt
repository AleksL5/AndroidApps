package com.example.architecture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUsefulActivityUseCase: GetUsefulActivityUseCase
) : ViewModel() {

    private val _activityState = MutableStateFlow<UsefulActivity?>(null)
    val activityState: StateFlow<UsefulActivity?> = _activityState

    fun reloadUsefulActivity() {
        viewModelScope.launch {
            val activity = getUsefulActivityUseCase.execute()
            _activityState.value = activity
        }
    }
}




//@HiltViewModel
//class MainViewModel @Inject constructor(
//    private val getUsefulActivityUseCase: GetUsefulActivityUseCase
//) : ViewModel() {
//
//    private val _activityState = MutableStateFlow<UsefulActivity?>(null)
//    val activityState: StateFlow<UsefulActivity?> get() = _activityState
//
//    fun reloadUsefulActivity() {
//        viewModelScope.launch {
//            _activityState.value = getUsefulActivityUseCase.execute()
//        }
//    }
//}