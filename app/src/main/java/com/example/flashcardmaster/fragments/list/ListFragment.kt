package com.example.flashcardmaster.fragments.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flashcardmaster.R
import com.example.flashcardmaster.viewmodel.FlashcardViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*

class listFragment : Fragment() {

    private lateinit var mFlashcardViewModel: FlashcardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_list, container, false)

        //RecyclerView
        val adapter = ListAdapter()
        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //FlashcardViewModel
        mFlashcardViewModel = ViewModelProvider(this).get(FlashcardViewModel::class.java)
        mFlashcardViewModel.readAllData.observe(viewLifecycleOwner, Observer { flashcard ->
            adapter.setData(flashcard)
        })

        view.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        //Add menu
        setHasOptionsMenu(true)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    private fun deleteFlashcard(){

    }

}