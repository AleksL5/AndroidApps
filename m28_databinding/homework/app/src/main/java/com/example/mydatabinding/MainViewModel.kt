package com.example.mydatabinding

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainViewModel(
    private val repository: Repository
) : ViewModel() {

    val requestString = MutableStateFlow<String>("")
    var foundText: String = "Здесь будет отображаться результат запроса"
    private val _state = MutableStateFlow(State.SEARCH_ON_PAUSE)
    val state = _state.asStateFlow()

    init {
        requestString.debounce(1000).onEach { value ->
            Log.d("HHHH", "requestingString.onEach $value ")
            find(value)
        }.launchIn(viewModelScope)
    }


    private fun find(value: String) {
        Log.d("HHHH", "suspend fun find working")
            foundText = "Поиск..."
            _state.value = State.SEARCH_IN_PROCESS
            foundText = "По запросу \"$value\" ничего не найдено"
            _state.value = State.SEARCH_ON_FINISH
    }
}
