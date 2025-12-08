package com.example.birdsofguatemala

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import com.example.birdsofguatemala.ui.theme.BirdsOfGuatemalaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirdsOfGuatemalaTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
fun HomeScreen() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top third: Title
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Birds of Guatemala",
                fontSize = 32.sp,
                style = MaterialTheme.typography.headlineMedium
            )
        }

        // Middle third: Name + ID
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Luis Diego Hernández León",
                    fontSize = 24.sp
                )
                Text(
                    text = "24000343",
                    fontSize = 20.sp
                )
            }
        }

        // Bottom third: GO Button
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {
                    // Navigate to next screen
                    //context.startActivity(Intent(context, BirdListActivity::class.java))
                },
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Text("GO")
            }
        }
    }
}
