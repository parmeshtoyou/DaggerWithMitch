package com.example.daggerwithmitch.di

import com.example.daggerwithmitch.di.auth.AuthModule
import com.example.daggerwithmitch.di.auth.AuthViewModelModule
import com.example.daggerwithmitch.di.main.MainFragmentsBuilderModule
import com.example.daggerwithmitch.di.main.MainModule
import com.example.daggerwithmitch.di.main.MainViewModelsModule
import com.example.daggerwithmitch.ui.auth.AuthActivity
import com.example.daggerwithmitch.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [AuthViewModelModule::class, AuthModule::class])
    abstract fun contributeAuthActivity(): AuthActivity

    @ContributesAndroidInjector(modules = [MainFragmentsBuilderModule::class,
        MainViewModelsModule::class, MainModule::class])
    abstract fun contributeMainActivity(): MainActivity
}