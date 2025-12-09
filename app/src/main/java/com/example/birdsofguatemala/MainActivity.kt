package com.example.birdsofguatemala

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign

class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen(onGo = {
                // Start BirdListActivity when GO is pressed
                startActivity(Intent(this@HomeActivity, BirdListActivity::class.java))
            })
        }
    }
}

@Composable
fun HomeScreen(onGo: () -> Unit) {
    // Layout split into three vertical thirds using weights
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Top third - title centered in top third
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Birds of Guatemala",
                fontSize = 28.sp,
                textAlign = TextAlign.Center
            )
        }

        // Middle third - name and ID centered in that third
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Luis Diego Hernández León", fontSize = 20.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "24000343", fontSize = 18.sp)
            }
        }

        // Bottom third - GO button centered
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = onGo,
                modifier = Modifier
                    .padding(horizontal = 40.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "GO")
            }
        }
    }
}
