package com.example.birdsofguatemala.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.example.birdsofguatemala.ui.screens.BirdListScreen
import com.example.birdsofguatemala.viewmodel.BirdViewModel

@Composable
fun NavGraph(navController: NavHostController, viewModel: BirdViewModel) {

    NavHost(
        navController = navController,
        startDestination = "bird_list"
    ) {
        composable("bird_list") {
            BirdListScreen(viewModel = viewModel)   // FIXED HERE
        }
    }
}
