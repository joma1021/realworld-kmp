package com.example.realworld_kmp.shared.repository

import com.example.realworld_kmp.shared.models.Article
import com.example.realworld_kmp.shared.models.ArticlesDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticleRepository(private val httpClient: HttpClient) {
  suspend fun getArticles(): List<Article> {
    val response = httpClient.get("articles").body<ArticlesDTO>()
    return response.articles
  }
}