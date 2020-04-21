package com.example.daggerwithmitch.ui.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.example.daggerwithmitch.SessionManager
import com.example.daggerwithmitch.models.User
import com.example.daggerwithmitch.network.auth.AuthApi
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    private val authApi: AuthApi,
    private val sessionManager: SessionManager
) : ViewModel() {

    fun authenticateWithId(id: Int) {
        Log.d("TESTING", "Authenticating with id")
        sessionManager.authenticateWithId(getUserById(id))
    }

    private fun getUserById(userId: Int): LiveData<AuthState<User>> {
        val subscriber = authApi.getUser(userId)
            .onErrorReturn { User(id = -1) }
            .map(object : Function<User, AuthState<User>> {
                override fun apply(t: User): AuthState<User> {
                    return if (t.id == -1) {
                        AuthState.Error(message = "Couldn't Authenticate User")
                    } else {
                        AuthState.Login(data = t)
                    }
                }
            })
            .subscribeOn(Schedulers.io())
        return LiveDataReactiveStreams.fromPublisher(subscriber)
    }

    fun observeUser(): LiveData<AuthState<User>> {
        return sessionManager.getAuthUser()
    }
}