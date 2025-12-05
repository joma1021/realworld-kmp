package com.example.realworld_kmp

import App
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.ComposeViewport
import androidx.navigation.ExperimentalBrowserHistoryApi
import androidx.navigation.bindToBrowserNavigation
import kotlinx.browser.document
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.preloadFont
import realworldkmp.composeapp.generated.resources.Res
import realworldkmp.composeapp.generated.resources.titillium_web_bold
import realworldkmp.composeapp.generated.resources.titillium_web_regular

@OptIn(
  ExperimentalComposeUiApi::class, ExperimentalComposeUiApi::class,
  ExperimentalBrowserHistoryApi::class, ExperimentalResourceApi::class
)

fun main() {
  val body = document.body ?: return
  ComposeViewport(body) {
    var fontsLoaded by remember { mutableStateOf(false) }
    val regularFont by preloadFont(Res.font.titillium_web_regular)
    val boldFont by preloadFont(Res.font.titillium_web_bold)

    LaunchedEffect(regularFont, boldFont) {
      fontsLoaded = true
      println("Fonts are ready")

    }

    if (fontsLoaded) {
      App(
        onNavHostReady = { it.bindToBrowserNavigation() }
      )
    } else {
      Box(
        modifier = Modifier.fillMaxSize().background(Color.White.copy(alpha = 0.8f))
          .clickable { }) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
      }
      println("Fonts are not ready yet")
    }
  }

}