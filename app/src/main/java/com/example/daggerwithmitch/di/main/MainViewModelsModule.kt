package com.example.daggerwithmitch.di.main

import androidx.lifecycle.ViewModel
import com.example.daggerwithmitch.di.main.keys.MainViewModelKey
import com.example.daggerwithmitch.ui.main.posts.PostViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelsModule {

    /*@MainScope
    @Binds
    @IntoMap
    @MainViewModelKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(profileViewModel: ProfileViewModel) : ViewModel*/

    @MainScope
    @Binds
    @IntoMap
    @MainViewModelKey(PostViewModel::class)
    abstract fun bindPostViewModel(postViewModel: PostViewModel): ViewModel
}