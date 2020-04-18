package com.example.daggerwithmitch.di

import com.example.daggerwithmitch.di.auth.AuthModule
import com.example.daggerwithmitch.di.auth.AuthViewModelModule
import com.example.daggerwithmitch.ui.auth.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [AuthViewModelModule::class, AuthModule::class])
    abstract fun contributeAuthActivity() : AuthActivity
}