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

    private var flashcardList = emptyList<flashcard>()
    private val selected_position = -1


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

        //makes it selectable
        holder.itemView.flashcardconstraintlayout.setOnLongClickListener{
            if(hasBackTextBeenDisplayed){holder.itemView.CARD_FRONT.setCardBackgroundColor(Color.parseColor("#808080"))
                hasBackTextBeenDisplayed = false
            }else {
                holder.itemView.CARD_BACK.setCardBackgroundColor(Color.parseColor("#808080"))
                hasBackTextBeenDisplayed = true
            }
            true

        }


        val currentItem = flashcardList[position]
        //used to flip between the values on the card

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

//    fun toggleItems(){
//        for(item: flashcard in flashcardList)
//    }

    fun setData(flashcard: List<flashcard>){
        this.flashcardList = flashcard
        notifyDataSetChanged()
    }

}