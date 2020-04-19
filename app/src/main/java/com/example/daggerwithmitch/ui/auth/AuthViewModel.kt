package com.example.daggerwithmitch.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.daggerwithmitch.models.User
import com.example.daggerwithmitch.network.auth.AuthApi
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthViewModel @Inject constructor(private val authApi: AuthApi) : ViewModel() {

    private val authUserLiveData = MediatorLiveData<AuthResource<User>>()

    fun authenticateWithId(id: Int) {
        authUserLiveData.value = AuthResource(AuthStatus.LOADING)
        val subscriber = authApi.getUser(id)
            .onErrorReturn { User(id = -1) }
            .map { t ->
                if (t.id == -1) {
                    AuthResource(AuthStatus.ERROR, message = "Couldn't Authenticate User")
                } else {
                    AuthResource(AuthStatus.AUTHENTICATED, data = t)
                }
            }
            .subscribeOn(Schedulers.io())
        val source = LiveDataReactiveStreams.fromPublisher(subscriber)

        authUserLiveData.addSource(source) {
            authUserLiveData.value = it
            authUserLiveData.removeSource(source)
        }
    }

    fun observeUser(): LiveData<AuthResource<User>> {
        return authUserLiveData
    }
}