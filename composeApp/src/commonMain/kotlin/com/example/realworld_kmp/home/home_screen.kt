package com.example.realworld_kmp.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen() {
  Column(

    modifier = Modifier
      .fillMaxSize(),
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colorScheme.primary),
      contentAlignment = Alignment.Center
    ) {
      Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
          .padding(vertical = 32.dp)
      ) {
        Text(
          text = "conduit",
          style = MaterialTheme.typography.headlineLarge.copy(
            color = Color.White, shadow = Shadow(
              color = Color.Gray,
              offset = Offset(0f, 0.2f),
              blurRadius = 4f
            )
          )
        )
        Text(
          text = "A place to share your knowledge",
          style = MaterialTheme.typography.headlineMedium.copy(
            color = Color.White,
          )
        )
      }

    }

  }
}
