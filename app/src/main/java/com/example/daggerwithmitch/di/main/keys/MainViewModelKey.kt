package com.example.daggerwithmitch.di.main.keys

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@MapKey
annotation class MainViewModelKey(val value: KClass<out ViewModel>)