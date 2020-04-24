package com.example.daggerwithmitch.network.main

import com.example.daggerwithmitch.models.post.Post
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface MainApi {
    @GET("/posts")
    fun getPosts(@Query("userId") id: Int): Flowable<List<Post>>
}