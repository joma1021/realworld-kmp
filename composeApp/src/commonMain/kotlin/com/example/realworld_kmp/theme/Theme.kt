package com.example.realworld_kmp.theme

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
fun RealWorldTheme(
  content: @Composable () -> Unit
) {

  val colorScheme = LightColorScheme

  MaterialTheme(
    colorScheme = colorScheme,
    content = content
  )
}