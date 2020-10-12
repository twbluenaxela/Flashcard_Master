package com.example.flashcardmaster

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.flashcardmaster.model.flashcard
import kotlinx.android.synthetic.main.card_front.view.*

class FlashcardRecyclerAdapterAKAScrollingManager(private val flashcardList: List<flashcard>) : Adapter<FlashcardRecyclerAdapterAKAScrollingManager.FlashcardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlashcardViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_front, parent, false)
        return FlashcardViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FlashcardViewHolder, position: Int) {
        val currentItem = flashcardList[position]

        //BEWARE, THIS LINE OF CODE MIGHT MESS UP
        //our flashcard class has takes a value also called flashcardFrontText,
        // so hopefully it doesn't take itself, and instead takes the value in the flashcard class
        holder.flashcardFrontText.text = currentItem.flashcardFrontText
//        holder.flashcardBackText.text = currentItem.flashcardBackText
    }


    override fun getItemCount() = flashcardList.size


    class FlashcardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val flashcardFrontText: TextView = itemView.flashcard_text_front
//        val flashcardBackText: TextView = itemView.flashcard_text_back
    }

}