package com.example.daggerwithmitch.di.auth

import com.example.daggerwithmitch.network.auth.AuthApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class AuthModule {

    @Provides
    fun provideAuthApi(retrofit: Retrofit) : AuthApi {
        return retrofit.create(AuthApi::class.java)
    }
}