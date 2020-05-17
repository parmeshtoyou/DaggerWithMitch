package com.example.daggerwithmitch.di.main

import com.example.daggerwithmitch.ui.main.MainActivity
import dagger.Subcomponent

@MainScope
@Subcomponent(modules = [MainModule::class, MainViewModelsModule::class])
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainComponent
    }

    fun inject(authActivity: MainActivity)
}