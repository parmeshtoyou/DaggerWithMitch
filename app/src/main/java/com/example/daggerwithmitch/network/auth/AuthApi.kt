package com.example.daggerwithmitch.network.auth

import com.example.daggerwithmitch.models.user.User
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthApi {

    @GET("/users/{id}")
    fun getUser(@Path("id") userId: Int): Flowable<User>
}