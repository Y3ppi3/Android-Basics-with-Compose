package com.example.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WaterCounter()
                }
            }
        }
    }
}

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // State for counter
        var count by remember { mutableStateOf(0) }

        // When count reaches or exceeds max value, show a different message
        if (count == 0) {
            Text(
                text = "You haven't had any glasses of water yet!",
                modifier = Modifier.padding(bottom = 8.dp)
            )
        } else {
            Text(
                text = "You've had $count glasses of water.",
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }

        Row(
            modifier = Modifier.padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Button to increment the count
            Button(
                onClick = { count++ },
                enabled = true,
                modifier = Modifier.width(120.dp)
            ) {
                Text(text = "Add one")
            }

            // Button to clear the count
            Button(
                onClick = { count = 0 },
                enabled = count > 0,
                modifier = Modifier.width(120.dp)
            ) {
                Text(text = "Clear")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WaterCounterPreview() {
    AppTheme {
        WaterCounter()
    }
}