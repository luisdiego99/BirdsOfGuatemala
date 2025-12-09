package com.example.birdsofguatemala

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.birdsofguatemala.ui.screens.BirdListScreen
import com.example.birdsofguatemala.viewmodel.BirdViewModel

class BirdListActivity : ComponentActivity() {

    private val viewModel : BirdViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BirdListScreen(viewModel = viewModel)  // FIXED
        }
    }
}
