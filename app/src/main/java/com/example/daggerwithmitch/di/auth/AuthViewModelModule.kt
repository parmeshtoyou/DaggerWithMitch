package com.example.daggerwithmitch.di.auth

import androidx.lifecycle.ViewModel
import com.example.daggerwithmitch.di.ViewModelKey
import com.example.daggerwithmitch.ui.auth.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthViewModelModule {

    @AuthScope
    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(authViewModel: AuthViewModel) : ViewModel
}