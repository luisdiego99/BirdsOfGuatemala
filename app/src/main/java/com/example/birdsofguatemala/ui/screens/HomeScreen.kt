package com.example.birdsofguatemala.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(nav: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Birds of Guatemala", fontSize = 36.sp)
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Luis Diego Hernández León", fontSize = 22.sp)
            Text("24000343", fontSize = 22.sp)
        }

        Button(onClick = { nav.navigate("birds") }) {
            Text("GO", fontSize = 22.sp)
        }
    }
}
