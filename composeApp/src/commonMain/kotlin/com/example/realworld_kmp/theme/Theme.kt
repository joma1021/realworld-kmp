package com.example.realworld_kmp.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(

  primary = Color(0xFF5cb85c),
  onPrimary = Color.White,
  secondary = Color(0xFF818a91),
  onSurface = Color.DarkGray,


  )

@Composable
fun RealworldTheme(
  darkTheme: Boolean = isSystemInDarkTheme(), // Automatischer Dark-Mode-Support
  content: @Composable () -> Unit
) {
  // Derzeit wird immer das helle Farbschema verwendet.
  // Sie können später ein `darkColorScheme` hinzufügen.
  val colorScheme = LightColorScheme

  MaterialTheme(
    colorScheme = colorScheme,
    content = content
  )
}