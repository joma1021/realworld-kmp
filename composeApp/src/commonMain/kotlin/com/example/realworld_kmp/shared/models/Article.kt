package com.example.realworld_kmp.shared.models

import kotlinx.serialization.Serializable

@Serializable
data class Article(
  val author: Author,
  val tagList: List<String>,
  val title: String,
  val description: String,
  val createdAt: String,
  val updatedAt: String,
  val favorited: Boolean,
  val favoritesCount: Int,
  val slug: String,
)

@Serializable
data class ArticlesDTO(
  val articles: List<Article>,
  val articlesCount: Int
)

@Serializable
data class EditArticle(
  val title: String,
  val description: String,
  val body: String,
  val tagList: List<String>
)



