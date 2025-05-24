package com.example.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.testapp.data.ArtworkRepository
import com.example.testapp.model.Artwork
import com.example.testapp.ui.theme.TestAppTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    // Получаем список произведений искусства
    val artworks = ArtworkRepository.getArtworks()

    // Состояние для отслеживания текущего индекса
    var currentIndex by rememberSaveable { mutableStateOf(0) }

    // Состояние для отслеживания видимости детального просмотра
    var showDetail by rememberSaveable { mutableStateOf(false) }

    // Выбранное произведение
    val currentArtwork = artworks[currentIndex]

    // Функции навигации
    val onNextArtwork: () -> Unit = {
        currentIndex = (currentIndex + 1) % artworks.size
    }

    val onPreviousArtwork: () -> Unit = {
        currentIndex = if (currentIndex > 0) currentIndex - 1 else artworks.size - 1
    }

    // Состояние для анимации
    val state = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }

    // Дата
    val currentDate = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(Date())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 36.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.Top // Выравнивание контента по верху
    ) {
        // Заголовок
        Text(
            text = "ArtSpace Gallery",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        Text(
            text = "Сегодня: $currentDate",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        // Карусель с тремя видимыми элементами
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(vertical = 8.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFFF3F3F3)),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Предыдущая карточка
                val prevIndex = if (currentIndex > 0) currentIndex - 1 else artworks.size - 1
                ArtworkCard(
                    artwork = artworks[prevIndex],
                    isSelected = false,
                    onClick = {
                        currentIndex = prevIndex
                    },
                    size = 100.dp
                )

                // Текущая карточка (увеличенная)
                ArtworkCard(
                    artwork = artworks[currentIndex],
                    isSelected = true,
                    onClick = {
                        showDetail = true
                    },
                    size = 120.dp
                )

                // Следующая карточка
                val nextIndex = (currentIndex + 1) % artworks.size
                ArtworkCard(
                    artwork = artworks[nextIndex],
                    isSelected = false,
                    onClick = {
                        currentIndex = nextIndex
                    },
                    size = 100.dp
                )
            }
        }

        // Минимальный отступ
        Spacer(modifier = Modifier.height(8.dp))

        // Информация о текущем произведении
        ArtworkInfo(
            artwork = currentArtwork,
            onNextArtwork = onNextArtwork,
            onPreviousArtwork = onPreviousArtwork,
            onShowDetail = { showDetail = true }
        )

        // Добавляем гибкий spacer, который займет все оставшееся место
        Spacer(modifier = Modifier.weight(1f))

        // Подпись
        Text(
            text = "Выполнил Корнеев - 2025",
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
        )
    }

    // Диалог с подробной информацией
    if (showDetail) {
        ArtworkDetailDialog(
            artwork = currentArtwork,
            onDismiss = { showDetail = false }
        )
    }
}

@Composable
fun ArtworkCard(
    artwork: Artwork,
    isSelected: Boolean,
    onClick: () -> Unit,
    size: androidx.compose.ui.unit.Dp
) {
    val elevation = if (isSelected) 8.dp else 1.dp
    val borderWidth = if (isSelected) 2.dp else 0.dp
    val alpha = if (isSelected) 1f else 0.7f

    Card(
        modifier = Modifier
            .width(size)
            .height(size + 24.dp)
            .padding(4.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = elevation),
        border = if (isSelected) BorderStroke(borderWidth, MaterialTheme.colorScheme.primary) else null
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.alpha(alpha)
        ) {
            Image(
                painter = painterResource(id = artwork.imageResId),
                contentDescription = artwork.title,
                modifier = Modifier
                    .height(size - 20.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = artwork.title,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                maxLines = 1,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}

@Composable
fun ArtworkInfo(
    artwork: Artwork,
    onNextArtwork: () -> Unit,
    onPreviousArtwork: () -> Unit,
    onShowDetail: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 0.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Изображение
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.LightGray)
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onDoubleTap = { onShowDetail() }
                        )
                    }
            ) {
                Image(
                    painter = painterResource(id = artwork.imageResId),
                    contentDescription = artwork.title,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Информация
            Text(
                text = artwork.title,
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = artwork.artist,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = artwork.year,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedButton(
                    onClick = onPreviousArtwork,
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Previous")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Пред.")
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(
                    onClick = onShowDetail,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Подробнее")
                }

                Spacer(modifier = Modifier.width(16.dp))

                OutlinedButton(
                    onClick = onNextArtwork,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("След.")
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(Icons.Default.ArrowForward, contentDescription = "Next")
                }
            }
        }
    }
}

@Composable
fun ArtworkDetailDialog(
    artwork: Artwork,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = artwork.imageResId),
                    contentDescription = artwork.title,
                    modifier = Modifier
                        .size(240.dp)
                        .padding(bottom = 16.dp),
                    contentScale = ContentScale.Fit
                )

                Text(
                    text = artwork.title,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Художник: ${artwork.artist}",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "Год создания: ${artwork.year}",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = artwork.description,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Justify
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = onDismiss,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Закрыть")
                }
            }
        }
    }
}

// Добавьте этот extension function для поддержки alpha
fun Modifier.alpha(alpha: Float): Modifier = this.then(
    Modifier.graphicsLayer(alpha = alpha)
)

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    TestAppTheme {
        ArtSpaceApp()
    }
}