package com.example.daggerwithmitch.di.auth

import com.example.daggerwithmitch.ui.auth.AuthActivity
import dagger.Subcomponent

@AuthScope
@Subcomponent(modules = [AuthModule::class, AuthViewModelModule::class, AuthFragmentsModule::class])
interface AuthComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): AuthComponent
    }

    fun inject(authActivity: AuthActivity)
}