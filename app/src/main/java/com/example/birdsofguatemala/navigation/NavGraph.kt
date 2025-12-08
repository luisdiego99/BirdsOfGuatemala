package com.example.birdsofguatemala.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.birdsofguatemala.ui.screens.HomeScreen
import com.example.birdsofguatemala.ui.screens.BirdListScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("birds") { BirdListScreen() }
    }
}
