package com.example.realworld_kmp.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font
import realworldkmp.composeapp.generated.resources.Res
import realworldkmp.composeapp.generated.resources.titillium_web_bold
import realworldkmp.composeapp.generated.resources.titillium_web_regular


@Composable
private fun _titilliumWebFontFamily(): FontFamily {
  return FontFamily(
    Font(Res.font.titillium_web_regular, FontWeight.Normal, style = FontStyle.Normal),
    Font(Res.font.titillium_web_bold, FontWeight.Bold, style = FontStyle.Normal)
  )
}

@Composable
fun appTypography() = Typography(
  bodyLarge = TextStyle(
    fontFamily = _titilliumWebFontFamily(), // Use your custom font here
    fontWeight = FontWeight.Normal
  ),
  headlineLarge = TextStyle(
    fontFamily = _titilliumWebFontFamily(),
    fontWeight = FontWeight.Bold,
    fontSize = 56.sp,
  ),
  headlineMedium = TextStyle(
    fontFamily = _titilliumWebFontFamily(),
    fontWeight = FontWeight.W300,
    fontSize = 24.sp,
  ),
  headlineSmall = TextStyle(
    fontFamily = _titilliumWebFontFamily(),
    fontWeight = FontWeight.W300,
    fontSize = 20.sp,
  ),
)






