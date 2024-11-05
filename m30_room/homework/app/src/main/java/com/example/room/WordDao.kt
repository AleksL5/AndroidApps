package com.example.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: WordEntity): Long

    @Query("UPDATE words SET count = count + 1 WHERE word = :word")
    suspend fun incrementCount(word: String)

    @Query("SELECT * FROM words ORDER BY count DESC LIMIT 5")
    fun getTopWords(): Flow<List<WordEntity>>

    @Query("DELETE FROM words")
    suspend fun clearAllWords()
}