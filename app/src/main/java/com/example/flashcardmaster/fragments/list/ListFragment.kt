package com.example.flashcardmaster.fragments.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flashcardmaster.R
import com.example.flashcardmaster.model.flashcard
import com.example.flashcardmaster.viewmodel.FlashcardViewModel
import kotlinx.android.synthetic.main.card_back.*
import kotlinx.android.synthetic.main.card_front.*
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_list.*
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

        //swipe to delete
        val itemTouchHelperCallback =
            object :
                ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    TODO("Not yet implemented")
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val index = viewHolder.adapterPosition
                    val adapter = ListAdapter()
                    mFlashcardViewModel.deleteFlashcard(adapter.flashcardList[index])
                    adapter.notifyDataSetChanged()
                }

            }
        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(view.recyclerview)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }


    private fun deleteFlashcard(){

    }

}