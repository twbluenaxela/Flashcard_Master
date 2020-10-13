package com.example.flashcardmaster.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.flashcardmaster.model.flashcard

@Dao
interface FlashcardDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFlashcard(flashcard: flashcard)

    @Delete
    suspend fun deleteFlashcard(flashcard: flashcard)

    @Query("DELETE FROM flashcard_table")
    suspend fun deleteAllFlashcards()

    @Query("SELECT * FROM flashcard_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<flashcard>>

}