package com.example.flashcardmaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flashcardmaster.model.flashcard
import kotlinx.android.synthetic.main.activity_flashcardlistpage.*

class flashcardListManager : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashcardlistpage)
        val exampleList = generateDummyList(30)
        flashcardRecyclerView.adapter = FlashcardRecyclerAdapterAKAScrollingManager(exampleList)
        flashcardRecyclerView.layoutManager = LinearLayoutManager(this)
        flashcardRecyclerView.setHasFixedSize(true)

    }

    private fun generateDummyList(size: Int): List<flashcard> {
        val list = ArrayList<flashcard>()

        for(i in 0 until size){
            val item = flashcard(i, "$i Hi", "Bye")
            list += item
        }
        return list
    }


}