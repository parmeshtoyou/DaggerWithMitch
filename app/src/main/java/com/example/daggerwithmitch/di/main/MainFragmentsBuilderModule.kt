package com.example.daggerwithmitch.di.main

import com.example.daggerwithmitch.di.auth.AuthScope
import com.example.daggerwithmitch.ui.main.posts.PostsFragment
import com.example.daggerwithmitch.ui.main.profile.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Named

@Module
abstract class MainFragmentsBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeProfileFragment() : ProfileFragment

    @ContributesAndroidInjector
    abstract fun contributePostFragment(): PostsFragment
}