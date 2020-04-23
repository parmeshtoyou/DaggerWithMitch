package com.example.daggerwithmitch.ui.main.posts

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?): Resource<T>(data)
    class Loading<T>: Resource<T>()
    class Failed<T>(error: String): Resource<T>(message = error)
}