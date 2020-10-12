package com.example.flashcardmaster.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.room.Update
import com.example.flashcardmaster.R

class UpdateFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update, container, false)
        //Add Menu
        setHasOptionsMenu(true)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if(item.itemId == R.id.menu_delete){
//            deleteUser()
//        }
//        return super.onOptionsItemSelected(item)
//    }

//    private fun deleteUser(){
//        val builder = AlertDialog.Builder(requireContext())
//        builder.setPositiveButton("Yes"){_,_->
//
//        }
//        builder.setNegativeButton("No"){_, _ -> }
//        builder.setTitle("Delete ${args.currentUser}")
//    }

}