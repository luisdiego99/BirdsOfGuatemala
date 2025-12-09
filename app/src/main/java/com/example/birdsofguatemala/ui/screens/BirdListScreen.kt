package com.example.birdsofguatemala.ui.screens

import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.birdsofguatemala.model.BirdItem
import com.example.birdsofguatemala.viewmodel.BirdViewModel

@Composable
fun BirdListScreen(
    viewModel: BirdViewModel = BirdViewModel(),
    onBirdClick: (BirdItem) -> Unit = {}
) {
    val birds by viewModel.birds.collectAsState()
    val context = LocalContext.current
    var currentPlayer by remember { mutableStateOf<MediaPlayer?>(null) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Birds of Guatemala",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        }

    ) { padding ->

        if (birds.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text("No birds found")
            }
        } else {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .background(Color(0xFFF5F5F5))
                    .padding(12.dp)
            ) {

                items(birds) { bird ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .clickable { onBirdClick(bird) },
                        shape = CardDefaults.shape,
                        elevation = CardDefaults.cardElevation(6.dp)
                    ) {

                        Column(modifier = Modifier.padding(14.dp)) {

                            Text(
                                text = bird.commonName,
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = bird.scientificName,
                                fontStyle = FontStyle.Italic,
                                color = Color.DarkGray,
                                style = MaterialTheme.typography.bodyMedium
                            )

                            Spacer(Modifier.height(6.dp))

                            Text("📍 ${bird.location}", color = Color(0xFF37474F))
                            Text("🎙 ${bird.recordist}", color = Color(0xFF455A64))

                            Spacer(Modifier.height(10.dp))

                            Button(
                                onClick = {
                                    if (currentPlayer != null && currentPlayer!!.isPlaying) {
                                        currentPlayer!!.stop()
                                        currentPlayer!!.reset()
                                        currentPlayer = null
                                    } else {
                                        currentPlayer?.stop()
                                        currentPlayer?.reset()

                                        currentPlayer = MediaPlayer().apply {
                                            setDataSource(bird.audioUrl)
                                            prepareAsync()
                                            setOnPreparedListener { start() }
                                        }
                                    }
                                },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("🔊 Play / Stop Audio")
                            }
                        }
                    }
                }
            }
        }
    }
}
