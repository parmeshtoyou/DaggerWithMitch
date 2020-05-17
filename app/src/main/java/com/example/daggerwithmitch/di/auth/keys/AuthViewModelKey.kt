package com.example.daggerwithmitch.di.auth.keys

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@MapKey
annotation class AuthViewModelKey(val value: KClass<out ViewModel>)