package com.example.birdsofguatemala.ui.screens

import android.media.MediaPlayer
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.birdsofguatemala.viewmodel.BirdViewModel

@Composable
fun BirdListScreen(vm: BirdViewModel = viewModel()) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Birds of Guatemala") })
        }
    ) { padding ->

        Column(modifier = Modifier.padding(padding)) {

            val birds = vm.birds.collectAsState().value

            Column(Modifier.verticalScroll(rememberScrollState()).fillMaxWidth()) {
                birds.forEach { bird ->

                    var player: MediaPlayer? by remember { mutableStateOf(null) }

                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth(),
                        elevation = CardDefaults.cardElevation(6.dp)
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {

                            Button(onClick = {
                                player?.release()
                                player = MediaPlayer().apply {
                                    setDataSource(bird.file)
                                    prepare()
                                    start()
                                }
                            }) {
                                Text(bird.en)
                            }

                            Text("Generic Name: ${bird.gen}")
                            Text("Specific Name: ${bird.sp}")
                            Text("Location: ${bird.loc}")
                            Text("Recordist: ${bird.rec}")
                        }
                    }
                }
            }
        }
    }
}
