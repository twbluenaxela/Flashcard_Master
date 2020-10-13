package com.example.flashcardmaster.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.flashcardmaster.R
import com.example.flashcardmaster.viewmodel.FlashcardViewModel
import com.example.flashcardmaster.model.flashcard
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class addFragment : Fragment() {

    private lateinit var mFlashcardViewModel: FlashcardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add, container, false)

        mFlashcardViewModel = ViewModelProvider(this).get(FlashcardViewModel::class.java)

        view.add_button.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase(){
        val flashcardFrontText = CARD_FRONT_EDIT_TEXT.text.toString()
        val flashcardBackText = CARD_BACK_EDIT_TEXT.text.toString()

        if(inputCheck(flashcardFrontText, flashcardBackText)){
            //Create Flashcard Object
            val flashcard = flashcard(0,flashcardFrontText,flashcardBackText)
            //Add Data to Database
            mFlashcardViewModel.addFlashcard(flashcard)
            Toast.makeText(requireContext(), "Successfully added. Now go forth, young Padawan.", Toast.LENGTH_LONG).show()
            //Navigate Back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "The flashcard has died in a horrible paper cut incident. Insert the information to let him live.", Toast.LENGTH_LONG).show()

        }


    }

    private fun inputCheck(flashcardFrontText: String, flashcardBackText: String): Boolean{
        return !(TextUtils.isEmpty(flashcardFrontText) && TextUtils.isEmpty(flashcardBackText))
    }

}