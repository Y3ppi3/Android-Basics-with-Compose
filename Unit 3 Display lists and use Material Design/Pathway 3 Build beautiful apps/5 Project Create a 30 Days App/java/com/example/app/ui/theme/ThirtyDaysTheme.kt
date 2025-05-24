package com.example.app.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Light theme colors for 30 Days App
private val LightColors = lightColorScheme(
    primary = wellness_light_primary,
    onPrimary = wellness_light_onPrimary,
    primaryContainer = wellness_light_primaryContainer,
    onPrimaryContainer = wellness_light_onPrimaryContainer,
    secondary = wellness_light_secondary,
    onSecondary = wellness_light_onSecondary,
    secondaryContainer = wellness_light_secondaryContainer,
    onSecondaryContainer = wellness_light_onSecondaryContainer,
    tertiary = wellness_light_tertiary,
    onTertiary = wellness_light_onTertiary,
    tertiaryContainer = wellness_light_tertiaryContainer,
    onTertiaryContainer = wellness_light_onTertiaryContainer,
    error = wellness_light_error,
    errorContainer = wellness_light_errorContainer,
    onError = wellness_light_onError,
    onErrorContainer = wellness_light_onErrorContainer,
    background = wellness_light_background,
    onBackground = wellness_light_onBackground,
    surface = wellness_light_surface,
    onSurface = wellness_light_onSurface,
    surfaceVariant = wellness_light_surfaceVariant,
    onSurfaceVariant = wellness_light_onSurfaceVariant,
    outline = wellness_light_outline,
    inverseOnSurface = wellness_light_inverseOnSurface,
    inverseSurface = wellness_light_inverseSurface,
    inversePrimary = wellness_light_inversePrimary
)

// Dark theme colors for 30 Days App
private val DarkColors = darkColorScheme(
    primary = wellness_dark_primary,
    onPrimary = wellness_dark_onPrimary,
    primaryContainer = wellness_dark_primaryContainer,
    onPrimaryContainer = wellness_dark_onPrimaryContainer,
    secondary = wellness_dark_secondary,
    onSecondary = wellness_dark_onSecondary,
    secondaryContainer = wellness_dark_secondaryContainer,
    onSecondaryContainer = wellness_dark_onSecondaryContainer,
    tertiary = wellness_dark_tertiary,
    onTertiary = wellness_dark_onTertiary,
    tertiaryContainer = wellness_dark_tertiaryContainer,
    onTertiaryContainer = wellness_dark_onTertiaryContainer,
    error = wellness_dark_error,
    errorContainer = wellness_dark_errorContainer,
    onError = wellness_dark_onError,
    onErrorContainer = wellness_dark_onErrorContainer,
    background = wellness_dark_background,
    onBackground = wellness_dark_onBackground,
    surface = wellness_dark_surface,
    onSurface = wellness_dark_onSurface,
    surfaceVariant = wellness_dark_surfaceVariant,
    onSurfaceVariant = wellness_dark_onSurfaceVariant,
    outline = wellness_dark_outline,
    inverseOnSurface = wellness_dark_inverseOnSurface,
    inverseSurface = wellness_dark_inverseSurface,
    inversePrimary = wellness_dark_inversePrimary
)

@Composable
fun ThirtyDaysTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColors
        else -> LightColors
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}