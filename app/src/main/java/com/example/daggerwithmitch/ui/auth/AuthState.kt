package com.example.daggerwithmitch.ui.auth

sealed class AuthState<T>(
    val data: T? = null,
    val message: String? = null) {

    class Login<T>(data: T) : AuthState<T>(data)
    class Logout<T>(data: T?): AuthState<T>(data)
    class Loading<T>(data: T? = null) : AuthState<T>(data)
    class Error<T>(message: String, data: T? = null) : AuthState<T>(data, message)
}
