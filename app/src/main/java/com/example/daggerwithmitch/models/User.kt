package com.example.daggerwithmitch.models

data class User(
    val address: Address? = null,
    val company: Company? = null,
    val email: String? = null,
    val id: Int,
    val name: String? = null,
    val phone: String? = null,
    val username: String? = null,
    val website: String? = null
)