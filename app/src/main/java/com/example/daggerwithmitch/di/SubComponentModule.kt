package com.example.daggerwithmitch.di

import com.example.daggerwithmitch.di.auth.AuthComponent
import com.example.daggerwithmitch.di.main.MainComponent
import dagger.Module

@Module(subcomponents = [AuthComponent::class, MainComponent::class])
class SubComponentModule