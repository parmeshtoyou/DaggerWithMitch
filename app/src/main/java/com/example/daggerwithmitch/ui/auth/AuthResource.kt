package com.example.daggerwithmitch.ui.auth

class AuthResource<T>(
    val authStatus: AuthStatus,
    val data: T? = null,
    val message: String? = null
) {
    fun <T> authenticated(data: T?): AuthResource<T?> {
        return AuthResource<T?>(AuthStatus.AUTHENTICATED, data, null)
    }

    fun <T> error(msg: String, data: T?): AuthResource<T?> {
        return AuthResource<T?>(AuthStatus.ERROR, data, msg)
    }

    fun <T> loading(data: T?): AuthResource<T?> {
        return AuthResource<T?>(AuthStatus.LOADING, data, null)
    }

    fun <T> logout(): AuthResource<T?> {
        return AuthResource<T?>(AuthStatus.NOT_AUTHENTICATED, null, null)
    }
}

enum class AuthStatus {
    AUTHENTICATED, LOADING, ERROR, NOT_AUTHENTICATED
}
