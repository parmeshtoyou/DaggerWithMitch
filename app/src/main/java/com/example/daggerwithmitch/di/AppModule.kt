package com.example.daggerwithmitch.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.daggerwithmitch.util.Constants
import com.example.daggerwithmitch.R
import com.example.daggerwithmitch.persistence.AccountPropertiesDao
import com.example.daggerwithmitch.persistence.AppDatabase
import com.example.daggerwithmitch.persistence.AppDatabase.Companion.DATABASE_NAME
import com.example.daggerwithmitch.persistence.AuthTokenDao
import com.example.daggerwithmitch.util.LiveDataCallAdapterFactory
import com.example.daggerwithmitch.util.PreferenceKeys
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object AppModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideSharedPreferences(
        application: Application
    ): SharedPreferences {
        return application
            .getSharedPreferences(
                PreferenceKeys.APP_PREFERENCES,
                Context.MODE_PRIVATE
            )
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideSharedPrefsEditor(
        sharedPreferences: SharedPreferences
    ): SharedPreferences.Editor {
        return sharedPreferences.edit()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideRetrofitBuilder(gsonBuilder: Gson): Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideAppDb(app: Application): AppDatabase {
        return Room
            .databaseBuilder(app, AppDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration() // get correct db version if schema changed
            .build()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideAuthTokenDao(db: AppDatabase): AuthTokenDao {
        return db.getAuthTokenDao()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideAccountPropertiesDao(db: AppDatabase): AccountPropertiesDao {
        return db.getAccountPropertiesDao()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideRequestOptions(): RequestOptions {
        return RequestOptions
            .placeholderOf(R.drawable.default_image)
            .error(R.drawable.default_image)
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideGlideInstance(application: Application, requestOptions: RequestOptions): RequestManager {
        return Glide.with(application)
            .setDefaultRequestOptions(requestOptions)
    }
}