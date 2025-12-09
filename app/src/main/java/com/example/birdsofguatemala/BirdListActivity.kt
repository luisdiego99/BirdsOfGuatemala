package com.example.birdsofguatemala

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class BirdListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirdsScreen()
        }
    }
}

// Data classes for API response
data class BirdResponse(val recordings: List<BirdItem>)
data class BirdItem(
    val en: String,
    val gen: String,
    val sp: String,
    val loc: String,
    val rec: String,
    val grp: String
)

// Retrofit API
interface XenoCantoApi {
    @GET("recordings")
    suspend fun getRecordings(
        @Query("query") query: String,
        @Query("key") key: String
    ): BirdResponse
}

@Composable
fun BirdsScreen() {
    val context = LocalContext.current
    var birds by remember { mutableStateOf(listOf<BirdItem>()) }
    val scope = rememberCoroutineScope()

    // Fetch API data
    LaunchedEffect(Unit) {
        scope.launch(Dispatchers.IO) {
            try {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://xeno-canto.org/api/3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                val api = retrofit.create(XenoCantoApi::class.java)
                val response = api.getRecordings("cnt:Guatemala", "dc16feccc884b424e592b38cb51bcda8260a44b9")
                birds = response.recordings.filter { it.grp == "birds" }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        // Fixed title at top
        Text(
            text = "Birds of Guatemala",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF1976D2))
                .padding(16.dp),
            color = Color.White
        )

        // LazyColumn with bird info
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            items(birds) { bird ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD))
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        // Name button
                        Button(
                            onClick = {
                                // Placeholder for future functionality
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = bird.en)
                        }

                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Generic Name: ${bird.gen}", fontSize = 16.sp)
                        Text(text = "Specific Name: ${bird.sp}", fontSize = 16.sp)
                        Text(text = "Location: ${bird.loc}", fontSize = 16.sp)
                        Text(text = "Recordist: ${bird.rec}", fontSize = 16.sp)
                    }
                }
            }
        }
    }
}
