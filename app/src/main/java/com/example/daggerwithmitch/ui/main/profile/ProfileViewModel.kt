package com.example.daggerwithmitch.ui.main.profile

import androidx.lifecycle.ViewModel
import com.example.daggerwithmitch.SessionManager
import javax.inject.Inject

class ProfileViewModel @Inject constructor(private val sessionManager: SessionManager): ViewModel() {

    fun getAuthenticatedUser() = sessionManager.getAuthUser()
}