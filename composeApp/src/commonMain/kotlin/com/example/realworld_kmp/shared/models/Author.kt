package com.example.realworld_kmp.shared.models

import kotlinx.serialization.Serializable

@Serializable
data class Author(
  val image: String,
  val username: String,
  val following: Boolean,
  val bio: String
)