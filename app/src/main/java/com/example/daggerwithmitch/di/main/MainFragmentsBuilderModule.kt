package com.example.daggerwithmitch.di.main

import com.example.daggerwithmitch.ui.main.posts.PostsFragment
import com.example.daggerwithmitch.ui.main.profile.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentsBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeProfileFragment() : ProfileFragment

    @ContributesAndroidInjector
    abstract fun contributePostFragment(): PostsFragment
}