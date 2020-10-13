package com.example.flashcardmaster.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.flashcardmaster.data.FlashcardDatabase
import com.example.flashcardmaster.repository.FlashcardRepository
import com.example.flashcardmaster.model.flashcard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FlashcardViewModel(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<flashcard>>
    private val repository: FlashcardRepository

    

    init {
        val flashcardDao = FlashcardDatabase.getDatabase(application).flashcardDao()
        repository = FlashcardRepository(flashcardDao)
        readAllData = repository.readAllData
    }

    fun addFlashcard(flashcard: flashcard){
        viewModelScope.launch(Dispatchers.IO){
            repository.addFlashcard(flashcard)
        }
    }

    fun deleteFlashcard(flashcard: flashcard){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteFlashcard(flashcard)
        }
    }

    fun deleteAllFlashcards(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllFlashcards()
        }
    }

}