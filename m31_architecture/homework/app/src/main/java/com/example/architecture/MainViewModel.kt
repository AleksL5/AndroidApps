package com.example.architecture

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val jokeRepository: JokeRepository
) : ViewModel() {

    private val _jokeState = MutableStateFlow<Joke?>(null)
    val jokeState: StateFlow<Joke?> = _jokeState


    fun reloadJoke() {
        viewModelScope.launch {
            try {
                val joke = jokeRepository.getRandomJoke()
                _jokeState.value = joke
            } catch (e: Exception) {
                Log.e("MainViewModel", "Failed to load joke", e)
            }
        }
    }
}
