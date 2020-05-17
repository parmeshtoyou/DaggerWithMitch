package com.example.daggerwithmitch.di.auth

import android.content.SharedPreferences
import com.example.daggerwithmitch.SessionManager
import com.example.daggerwithmitch.api.auth.OpenApiAuthService
import com.example.daggerwithmitch.persistence.AccountPropertiesDao
import com.example.daggerwithmitch.persistence.AuthTokenDao
import com.example.daggerwithmitch.repository.auth.AuthRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object AuthModule {

    @JvmStatic
    @AuthScope
    @Provides
    fun provideOpenApiAuthService(retrofitBuilder: Retrofit.Builder): OpenApiAuthService {
        return retrofitBuilder
            .build()
            .create(OpenApiAuthService::class.java)
    }

    @JvmStatic
    @AuthScope
    @Provides
    fun provideAuthRepository(
        sessionManager: SessionManager,
        authTokenDao: AuthTokenDao,
        accountPropertiesDao: AccountPropertiesDao,
        openApiAuthService: OpenApiAuthService,
        preferences: SharedPreferences,
        editor: SharedPreferences.Editor
    ): AuthRepository {
        return AuthRepository(
            authTokenDao,
            accountPropertiesDao,
            openApiAuthService,
            sessionManager,
            preferences,
            editor
        )
    }
}