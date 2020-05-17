package com.example.daggerwithmitch.di.main

import android.app.Application
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daggerwithmitch.network.main.MainApi
import com.example.daggerwithmitch.ui.main.posts.PostsAdapter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object MainModule {

    @JvmStatic
    @MainScope
    @Provides
    fun provideMainApi(retrofit: Retrofit): MainApi {
        return retrofit.create(MainApi::class.java)
    }

    @JvmStatic
    @MainScope
    @Provides
    fun provideLinearLayoutManager(application: Application) =
        LinearLayoutManager(application.applicationContext)

    @JvmStatic
    @MainScope
    @Provides
    fun providePostAdapter() = PostsAdapter()
}