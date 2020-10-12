package com.example.flashcardmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        val navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        //I named it 2 so it wouldn't have any conflicts with the one on the top.
        val navController2 = findNavController(R.id.fragment)
        return navController2.navigateUp() || super.onSupportNavigateUp()
    }

    fun launchSecondActivity(view: View) {
        val intent = Intent(this, flashcardListManager:: class.java)
        startActivity(intent)
    }
}