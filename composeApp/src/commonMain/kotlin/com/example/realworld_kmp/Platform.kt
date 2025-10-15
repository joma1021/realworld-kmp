package com.example.realworld_kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform