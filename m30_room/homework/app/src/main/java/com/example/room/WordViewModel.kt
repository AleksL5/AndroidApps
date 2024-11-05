package com.example.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WordViewModel(private val wordDao: WordDao) : ViewModel() {

    val topWords: Flow<List<WordEntity>> = wordDao.getTopWords()

    fun addWord(word: String) {
        viewModelScope.launch {
            if (isValidWord(word)) {
                if (wordDao.insert(WordEntity(word)) == -1L) {
                    wordDao.incrementCount(word)
                }
            }
        }
    }

    fun clearWords() {
        viewModelScope.launch {
            wordDao.clearAllWords()
        }
    }

    fun isValidWord(word: String): Boolean {
        val regex = Regex("^[a-zA-Zа-яА-Я-]+$")
        return word.isNotBlank() && regex.matches(word)
    }
}