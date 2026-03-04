package com.example.realworld_kmp.pages.home.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.realworld_kmp.shared.models.Article
import com.example.realworld_kmp.shared.repository.ArticleRepository
import com.example.realworld_kmp.shared.state.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: ArticleRepository) : ViewModel() {
  private val _state =
    MutableStateFlow<UiState<List<Article>>>(UiState.Loading)
  val state = _state.asStateFlow()

  init {
    loadArticles()
  }

  fun loadArticles() {
    viewModelScope.launch {
      _state.value = UiState.Loading
      try {
        val articles = repository.getArticles()
        _state.value = UiState.Success(data = articles)
      } catch (e: Exception) {
        _state.value = UiState.Error(message = e.message ?: "Unknown Error")
      }
    }
  }
}
