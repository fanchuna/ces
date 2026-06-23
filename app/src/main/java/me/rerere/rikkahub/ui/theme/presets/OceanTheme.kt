package me.rerere.rikkahub.ui.theme.presets

import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import me.rerere.rikkahub.R
import me.rerere.rikkahub.ui.theme.PresetTheme

val OceanThemePreset by lazy {
    PresetTheme(
        id = "ocean",
        name = {
            Text(stringResource(id = R.string.theme_name_ocean))
        },
        standardLight = lightScheme,
        standardDark = darkScheme,
    )
}

private val primaryLight = Color(0xFF006D8F)
private val onPrimaryLight = Color(0xFFFFFFFF)
private val primaryContainerLight = Color(0xFFC7EDFF)
private val onPrimaryContainerLight = Color(0xFF003546)
private val secondaryLight = Color(0xFF49636D)
private val onSecondaryLight = Color(0xFFFFFFFF)
private val secondaryContainerLight = Color(0xFFD2E7F0)
private val onSecondaryContainerLight = Color(0xFF1F333C)
private val tertiaryLight = Color(0xFF7A5D00)
private val onTertiaryLight = Color(0xFFFFFFFF)
private val tertiaryContainerLight = Color(0xFFFFE08A)
private val onTertiaryContainerLight = Color(0xFF2A2100)
private val errorLight = Color(0xFFBA1A1A)
private val onErrorLight = Color(0xFFFFFFFF)
private val errorContainerLight = Color(0xFFFFDAD6)
private val onErrorContainerLight = Color(0xFF93000A)
private val backgroundLight = Color(0xFFF4FAFC)
private val onBackgroundLight = Color(0xFF161D20)
private val surfaceLight = Color(0xFFF4FAFC)
private val onSurfaceLight = Color(0xFF161D20)
private val surfaceVariantLight = Color(0xFFDCE7EC)
private val onSurfaceVariantLight = Color(0xFF404B50)
private val outlineLight = Color(0xFF6F7A80)
private val outlineVariantLight = Color(0xFFBFCBD1)
private val scrimLight = Color(0xFF000000)
private val inverseSurfaceLight = Color(0xFF2B3235)
private val inverseOnSurfaceLight = Color(0xFFECF2F5)
private val inversePrimaryLight = Color(0xFF8BD2F0)
private val surfaceDimLight = Color(0xFFD5DEE2)
private val surfaceBrightLight = Color(0xFFF8FCFE)
private val surfaceContainerLowestLight = Color(0xFFFFFFFF)
private val surfaceContainerLowLight = Color(0xFFEFF8FC)
private val surfaceContainerLight = Color(0xFFE6F2F7)
private val surfaceContainerHighLight = Color(0xFFDDECF2)
private val surfaceContainerHighestLight = Color(0xFFD4E5EC)

private val primaryDark = Color(0xFF8BD2F0)
private val onPrimaryDark = Color(0xFF003546)
private val primaryContainerDark = Color(0xFF004D65)
private val onPrimaryContainerDark = Color(0xFFC7EDFF)
private val secondaryDark = Color(0xFFB6CBD5)
private val onSecondaryDark = Color(0xFF20333C)
private val secondaryContainerDark = Color(0xFF354A53)
private val onSecondaryContainerDark = Color(0xFFD2E7F0)
private val tertiaryDark = Color(0xFFEBC248)
private val onTertiaryDark = Color(0xFF403100)
private val tertiaryContainerDark = Color(0xFF5C4600)
private val onTertiaryContainerDark = Color(0xFFFFE08A)
private val errorDark = Color(0xFFFFB4AB)
private val onErrorDark = Color(0xFF690005)
private val errorContainerDark = Color(0xFF93000A)
private val onErrorContainerDark = Color(0xFFFFDAD6)
private val backgroundDark = Color(0xFF071A23)
private val onBackgroundDark = Color(0xFFD8E6EC)
private val surfaceDark = Color(0xFF071A23)
private val onSurfaceDark = Color(0xFFD8E6EC)
private val surfaceVariantDark = Color(0xFF3F4B50)
private val onSurfaceVariantDark = Color(0xFFBFCBD1)
private val outlineDark = Color(0xFF89959B)
private val outlineVariantDark = Color(0xFF3F4B50)
private val scrimDark = Color(0xFF000000)
private val inverseSurfaceDark = Color(0xFFD8E6EC)
private val inverseOnSurfaceDark = Color(0xFF263238)
private val inversePrimaryDark = Color(0xFF006D8F)
private val surfaceDimDark = Color(0xFF071A23)
private val surfaceBrightDark = Color(0xFF263B45)
private val surfaceContainerLowestDark = Color(0xFF041117)
private val surfaceContainerLowDark = Color(0xFF0D222B)
private val surfaceContainerDark = Color(0xFF122A34)
private val surfaceContainerHighDark = Color(0xFF1B343E)
private val surfaceContainerHighestDark = Color(0xFF263F49)

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)
