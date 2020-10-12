package com.example.flashcardmaster.repository

import androidx.lifecycle.LiveData
import com.example.flashcardmaster.data.FlashcardDao
import com.example.flashcardmaster.model.flashcard

class FlashcardRepository(private val flashcardDao: FlashcardDao) {
    val readAllData: LiveData<List<flashcard>> = flashcardDao.readAllData()
    suspend fun addFlashcard(flashcard: flashcard){
        flashcardDao.addFlashcard(flashcard)
    }

    suspend fun deleteFlashcard(flashcard: flashcard){
        flashcardDao.deleteFlashcard(flashcard)
    }

    suspend fun deleteAllFlashcards(){
        flashcardDao.deleteAllFlashcards()
    }

}