package com.example.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WordViewModel(private val repository: WordRepository) : ViewModel() {

    val topWords: Flow<List<WordEntity>> = repository.topWords

    fun addWord(word: String) {
        if (isValidWord(word)) {
            viewModelScope.launch {
                repository.addWord(word)
            }
        }
    }

    fun clearWords() {
        viewModelScope.launch {
            repository.clearWords()
        }
    }

    fun isValidWord(word: String): Boolean {
        return word.isNotEmpty() && word.matches(Regex("^[a-zA-Z-]+$"))
    }
}

class WordViewModelFactory(private val repository: WordRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WordViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}