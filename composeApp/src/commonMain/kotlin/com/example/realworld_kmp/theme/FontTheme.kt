package com.example.realworld_kmp.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import realworldkmp.composeapp.generated.resources.Res
import realworldkmp.composeapp.generated.resources.titillium_web_bold
import realworldkmp.composeapp.generated.resources.titillium_web_regular


@Composable
fun titilliumWebFontFamily(): FontFamily {
  return FontFamily(
    Font(Res.font.titillium_web_regular, FontWeight.Normal),
    Font(Res.font.titillium_web_bold, FontWeight.Bold)

  )
}


