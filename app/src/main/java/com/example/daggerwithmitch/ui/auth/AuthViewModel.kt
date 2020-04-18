package com.example.daggerwithmitch.ui.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.daggerwithmitch.network.auth.AuthApi
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthViewModel @Inject constructor(private val authApi: AuthApi) : ViewModel() {

    fun fetchUser(userId: Int) {
        val observable =
            authApi.getUser(userId).toObservable().subscribeOn(Schedulers.io()).subscribe(
                { user ->
                    Log.d("Testing", "userName:${user.username}")
                }, { error ->
                    Log.d("Testing", "Error:$error")
                }
            )
    }
}