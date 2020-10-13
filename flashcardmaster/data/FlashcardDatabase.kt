package com.example.flashcardmaster.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.flashcardmaster.model.flashcard

@Database(entities = [flashcard::class], version = 1, exportSchema = false)
abstract class FlashcardDatabase: RoomDatabase() {

     abstract fun flashcardDao(): FlashcardDao

    companion object{
        @Volatile
        private var INSTANCE: FlashcardDatabase? = null

        fun getDatabase(context: Context): FlashcardDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FlashcardDatabase::class.java,
                    "flashcard_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}