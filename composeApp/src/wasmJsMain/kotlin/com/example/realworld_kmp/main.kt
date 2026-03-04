package com.example.realworld_kmp

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
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

    val regularFont by preloadFont(Res.font.titillium_web_regular)
    val boldFont by preloadFont(Res.font.titillium_web_bold)

    LaunchedEffect(regularFont, boldFont) {
      println("Fonts are ready")

    }

    App(
      onNavHostReady = { it.bindToBrowserNavigation() }
    )
  }


}