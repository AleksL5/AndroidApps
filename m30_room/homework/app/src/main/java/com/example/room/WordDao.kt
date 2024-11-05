package com.example.room

import androidx.room.*
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {
    @Query("UPDATE words SET count = count + 1 WHERE word = :word")
    suspend fun incrementWordCount(word: String): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertWord(wordEntity: WordEntity)

    @Query("DELETE FROM words")
    suspend fun clearWords()

    @Query("SELECT * FROM words ORDER BY count DESC LIMIT 5")
    fun getTopWords(): Flow<List<WordEntity>>

    @Query("SELECT COUNT(*) FROM words WHERE word = :word")
    suspend fun getWordCount(word: String): Int
}