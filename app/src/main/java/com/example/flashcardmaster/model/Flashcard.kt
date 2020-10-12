package com.example.flashcardmaster.model

import android.os.Parcelable
import android.widget.CheckBox
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "flashcard_table")
data class flashcard(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val flashcardFrontText: String,
    val flashcardBackText: String

): Parcelable


//data class flashcard (val flashcardFrontText: String, val flashcardBackText: String)