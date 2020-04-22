package com.example.daggerwithmitch.network.main

import com.example.daggerwithmitch.models.post.Posts
import com.example.daggerwithmitch.models.user.User
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface MainApi {
    @GET("/posts")
    fun getPosts(@Query("userId") id: Int): Flowable<Posts>
}