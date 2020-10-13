package com.example.flashcardmaster.fragments.list

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flashcardmaster.R
import com.example.flashcardmaster.model.flashcard
import kotlinx.android.synthetic.main.card_back.view.*
import kotlinx.android.synthetic.main.card_front.view.*
import kotlinx.android.synthetic.main.card_front.view.flashcardconstraintlayout

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    var flashcardList = emptyList<flashcard>()
//    var hasFlashcardBeenSelected = false


    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.card_front,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var hasBackTextBeenDisplayed = false;


        val currentItem = flashcardList[position]

        //displays the cards
        holder.itemView.flashcard_text_front.text = currentItem.flashcardFrontText

        //when clicked, it will show the back text and vice versa
        holder.itemView.flashcardconstraintlayout.setOnClickListener{
            if (hasBackTextBeenDisplayed){holder.itemView.flashcard_text_front.text = currentItem.flashcardFrontText
                hasBackTextBeenDisplayed = false
            }else{
                holder.itemView.flashcard_text_front.text = currentItem.flashcardBackText
                hasBackTextBeenDisplayed = true
            }
        }


    }

    override fun getItemCount(): Int {
        return flashcardList.size

    }

//    fun deleteFlashcard(position: Int){
//        this.deleteFlashcard(flashcardList[position])
//    }
//

    fun setData(flashcard: List<flashcard>){
        this.flashcardList = flashcard
        notifyDataSetChanged()
    }


}