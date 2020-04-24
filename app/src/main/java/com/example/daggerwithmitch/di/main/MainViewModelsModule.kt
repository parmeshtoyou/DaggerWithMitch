package com.example.daggerwithmitch.di.main

import androidx.lifecycle.ViewModel
import com.example.daggerwithmitch.di.ViewModelKey
import com.example.daggerwithmitch.ui.main.posts.PostViewModel
import com.example.daggerwithmitch.ui.main.profile.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelsModule {

    @MainScope
    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(profileViewModel: ProfileViewModel) : ViewModel

    @MainScope
    @Binds
    @IntoMap
    @ViewModelKey(PostViewModel::class)
    abstract fun bindPostViewModel(postViewModel: PostViewModel): ViewModel
}