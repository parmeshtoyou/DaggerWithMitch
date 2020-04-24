package com.example.daggerwithmitch.di

import android.app.Application
import com.example.daggerwithmitch.BaseApplication
import com.example.daggerwithmitch.SessionManager
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, AppModule::class,
        ActivityBuilderModule::class, ViewModelFactoryModule::class]
)
interface AppComponent : AndroidInjector<BaseApplication> {

    fun getSession(): SessionManager

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}