package com.example.myapplication.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

private val LightColors = lightColorScheme(
    primary = Primary,
    onPrimary = Background,
    primaryContainer = PrimarySoft,
    onPrimaryContainer = Primary,
    secondary = Primary,
    onSecondary = Background,
    background = Background,
    onBackground = TextAndIcons,
    surface = Background,
    onSurface = TextAndIcons,
    onSurfaceVariant = TextSecondary,
    surfaceContainerLowest = Background,
    surfaceContainerLow = Surface,
    surfaceContainer = Surface,
    surfaceContainerHigh = SurfaceStrong,
    surfaceContainerHighest = SurfaceStrong,
    outline = BorderMedium,
    outlineVariant = BorderButton,
    error = Error,
    onError = Background,
    inverseSurface = SurfaceDark,
    inverseOnSurface = TextOnDark,
    inversePrimary = Primary,
    scrim = SurfaceDark,
)

private val DarkColors = darkColorScheme(
    primary = Primary,
    onPrimary = Background,
    primaryContainer = DarkPrimarySoft,
    onPrimaryContainer = Primary,
    secondary = Primary,
    onSecondary = Background,
    background = DarkBackground,
    onBackground = DarkText,
    surface = DarkBackground,
    onSurface = DarkText,
    onSurfaceVariant = TextSecondary,
    surfaceContainerLowest = DarkBackground,
    surfaceContainerLow = DarkSurface,
    surfaceContainer = DarkSurface,
    surfaceContainerHigh = DarkSurfaceStrong,
    surfaceContainerHighest = DarkSurfaceStrong,
    outline = DarkBorder,
    outlineVariant = TextSecondary,
    error = Error,
    onError = SurfaceDark,
    inverseSurface = TextOnDark,
    inverseOnSurface = SurfaceDark,
    inversePrimary = Primary,
)

private val AppShapes = Shapes(
    extraSmall = RoundedCornerShape(4.dp), // snackbar
    small = RoundedCornerShape(8.dp), // caixa do ícone do dispositivo
    medium = RoundedCornerShape(12.dp), // cards
    large = RoundedCornerShape(16.dp), // diálogo
    extraLarge = RoundedCornerShape(28.dp), // bottom sheet
)

@Composable
fun GuardianTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = Typography,
        shapes = AppShapes,
        content = content,
    )
}
