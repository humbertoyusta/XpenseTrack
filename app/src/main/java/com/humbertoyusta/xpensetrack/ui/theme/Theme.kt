package com.humbertoyusta.xpensetrack.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(

    // Primary colors
    primary = PurpleMain,
    onPrimary = LightGray,

    // Background colors
    background = BackgroundBlack,
    onBackground = LightGray,
    surface = Color.Black,
    onSurface = Color.White,

    // Secondary colors
    secondary = PurpleMainLighter,
    onSecondary = LightGray,

    // Tertiary colors
    tertiary = PurpleMainLighter,
    onTertiary = LightGray,

    /* Other default colors to override
    surface = Color(0xFFFFFBFE),
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

private val LightColorScheme = lightColorScheme(

    // Primary colors
    primary = PurpleMain,
    onPrimary = Color.White,

    // Background colors
    background = BackgroundGray,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Gray,

    // Secondary colors
    secondary = PurpleMainLighter,
    onSecondary = Color.White,

    // Tertiary colors
    tertiary = LightPurple,
    onTertiary = Color.White,

    /* Other default colors to override
    surface = Color(0xFFFFFBFE),
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun XpenseTrackTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}