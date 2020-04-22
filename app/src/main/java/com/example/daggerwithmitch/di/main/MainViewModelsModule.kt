package com.example.daggerwithmitch.di.main

import androidx.lifecycle.ViewModel
import com.example.daggerwithmitch.di.ViewModelKey
import com.example.daggerwithmitch.ui.main.profile.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(profileViewModel: ProfileViewModel) : ViewModel
}