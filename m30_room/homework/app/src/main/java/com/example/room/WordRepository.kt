package com.example.room

import kotlinx.coroutines.flow.Flow

class WordRepository(private val wordDao: WordDao) {

    val topWords: Flow<List<WordEntity>> = wordDao.getTopWords()

    suspend fun addWord(word: String) {
        if (wordDao.getWordCount(word) > 0) {
            wordDao.incrementWordCount(word)
        } else {
            wordDao.insertWord(WordEntity(word))
        }
    }

    suspend fun clearWords() {
        wordDao.clearWords()
    }
}