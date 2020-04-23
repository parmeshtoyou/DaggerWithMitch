package com.example.daggerwithmitch.models.post

data class Post(
    val body: String? = null,
    val id: Int,
    val title: String? = null,
    val userId: Int? = null
)