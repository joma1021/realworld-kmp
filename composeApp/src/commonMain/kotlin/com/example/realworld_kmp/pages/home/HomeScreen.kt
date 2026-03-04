package com.example.realworld_kmp.pages.home

import NetworkModule
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.unit.dp
import com.example.realworld_kmp.pages.home.state.HomeViewModel
import com.example.realworld_kmp.shared.repository.ArticleRepository
import com.example.realworld_kmp.shared.state.UiState


@Composable
fun HomeScreen(
  viewModel: HomeViewModel = remember { HomeViewModel(ArticleRepository(NetworkModule.client)) }
) {
  val articleState by viewModel.state.collectAsState()

  Column(
    modifier = Modifier
      .fillMaxSize()
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
        Spacer(modifier = Modifier.height(32.dp))
      }
    }
    Box(
      modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
      contentAlignment = Alignment.Center
    ) {
      when (val state = articleState) {
        is UiState.Loading -> {
          CircularProgressIndicator()
        }

        is UiState.Success -> {
          LazyColumn(
            modifier = Modifier.fillMaxSize()
          ) {
            items(state.data) { article ->
              Text(
                text = article.title,
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(16.dp),
                style = MaterialTheme.typography.bodyLarge
              )
            }
          }
        }

        is UiState.Error -> {
          Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Fehler: ${state.message}", color = Color.Red)
            Button(onClick = { viewModel.loadArticles() }) {
              Text("Wiederholen")
            }
          }
        }
      }
    }
  }
}
