package com.example.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app.ui.theme.AppTheme
import kotlin.random.Random

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
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeApp() {
    // Current step the app is displaying (from 1 to 4)
    var currentStep by remember { mutableStateOf(1) }

    // Number of taps needed to squeeze the lemon (random between 2-4)
    var squeezeCount by remember { mutableStateOf(0) }

    // Function to determine what happens when screen is tapped
    fun onImageClick() {
        when (currentStep) {
            1 -> {
                // From lemon tree, go to squeeze step and set random squeeze count
                currentStep = 2
                squeezeCount = Random.nextInt(2, 5)
            }
            2 -> {
                // Squeeze lemon until squeezeCount reaches 0
                squeezeCount--
                if (squeezeCount == 0) {
                    currentStep = 3
                }
            }
            3 -> {
                // From lemonade, go to empty glass
                currentStep = 4
            }
            4 -> {
                // From empty glass, go back to lemon tree
                currentStep = 1
            }
        }
    }

    val (textResource, imageResource, contentDescription) = when (currentStep) {
        1 -> Triple(
            "Tap the lemon tree to select a lemon",
            R.drawable.lemon_tree,
            "Lemon tree"
        )
        2 -> Triple(
            "Keep tapping the lemon to squeeze it",
            R.drawable.lemon_squeeze,
            "Lemon"
        )
        3 -> Triple(
            "Tap the lemonade to drink it",
            R.drawable.lemon_drink,
            "Glass of lemonade"
        )
        else -> Triple(
            "Tap the empty glass to start again",
            R.drawable.lemon_restart,
            "Empty glass"
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = textResource,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Image with clickable background
        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFFD2E8D4))
                .clickable { onImageClick() }
                .wrapContentSize(Alignment.Center)
        ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = contentDescription,
                modifier = Modifier.size(160.dp)
            )
        }

        // Display squeeze count info only when on step 2 (squeezing the lemon)
        if (currentStep == 2 && squeezeCount > 0) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Squeezes left: $squeezeCount",
                fontSize = 16.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeAppPreview() {
    AppTheme {
        LemonadeApp()
    }
}