package com.example.daggerwithmitch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.daggerwithmitch.models.User
import com.example.daggerwithmitch.ui.auth.AuthState
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor() {

    private val cachedUser = MediatorLiveData<AuthState<User>>()

    fun authenticateWithId(source: LiveData<AuthState<User>>) {
        cachedUser.value = AuthState.Loading()
        cachedUser.addSource(source) {
            //setting logged in user
            cachedUser.value = it
            cachedUser.removeSource(source)
        }
    }

    fun logout() {
        cachedUser.value = AuthState.Logout(null)
    }

    fun getAuthUser(): LiveData<AuthState<User>> = cachedUser
}