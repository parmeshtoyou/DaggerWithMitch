package com.example.daggerwithmitch.ui.main.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.daggerwithmitch.R
import com.example.daggerwithmitch.models.user.User
import com.example.daggerwithmitch.ui.auth.AuthState
import com.example.daggerwithmitch.viewmodel.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.profile_fragment.*
import javax.inject.Inject

class ProfileFragment : DaggerFragment() {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileViewModel = ViewModelProvider(this, providerFactory)[ProfileViewModel::class.java]
        return layoutInflater.inflate(R.layout.profile_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObserver()
    }

    private fun subscribeObserver() {
        profileViewModel.getAuthenticatedUser().removeObservers(viewLifecycleOwner)
        profileViewModel.getAuthenticatedUser().observe(viewLifecycleOwner, Observer {
            it?.let { authState ->
                when(authState) {
                    is AuthState.Login -> {
                        updateUserInformation(authState.data as User)
                    }
                    is AuthState.Error -> {
                        updateErrorInfo(authState.message)
                    }
                }
            }
        })
    }

    private fun updateErrorInfo(message: String?) {
        username.text = message
        email.text = "Error"
        website.text = "Error"
    }

    private fun updateUserInformation(user: User) {
        username.text = user.username
        email.text = user.email
        website.text = user.website
    }
}