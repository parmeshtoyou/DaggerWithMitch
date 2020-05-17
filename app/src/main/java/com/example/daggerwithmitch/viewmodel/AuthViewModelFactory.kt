package com.example.daggerwithmitch.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.daggerwithmitch.di.auth.AuthScope
import javax.inject.Inject
import javax.inject.Provider

@AuthScope
class AuthViewModelFactory
@Inject constructor(
    private val mainCreators: MutableMap<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var creator: Provider<out ViewModel>? = mainCreators[modelClass]
        if (creator == null) {
            for (entry in mainCreators.entries) {
                if (modelClass.isAssignableFrom(modelClass)) {
                    creator = entry.value
                    break
                }
            }
        }
        requireNotNull(creator) { "unknown model class" }
        return creator.get() as T
    }
}

