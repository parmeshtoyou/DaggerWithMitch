package com.example.daggerwithmitch.di

import android.app.Application
import com.example.daggerwithmitch.BaseActivity
import com.example.daggerwithmitch.SessionManager
import com.example.daggerwithmitch.di.auth.AuthComponent
import com.example.daggerwithmitch.di.main.MainComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, SubComponentModule::class])
interface AppComponent {

    fun getSession(): SessionManager

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun attach(baseActivity: BaseActivity)

    fun authComponent() : AuthComponent.Factory

    fun mainComponent() : MainComponent.Factory
}