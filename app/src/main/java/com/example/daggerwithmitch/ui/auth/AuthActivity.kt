package com.example.daggerwithmitch.ui.auth

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.example.daggerwithmitch.R
import com.example.daggerwithmitch.ui.main.MainActivity
import com.example.daggerwithmitch.viewmodel.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.auth_activity.*
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private lateinit var authViewModel: AuthViewModel

    @Inject
    lateinit var appIcon: Drawable

    @Inject
    lateinit var requestManager: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.auth_activity)

        authViewModel = ViewModelProvider(this, viewModelProviderFactory)[AuthViewModel::class.java]

        setLogo()
        subscribeObserver()

        login_button.setOnClickListener {
            if (user_id_input.text.toString().isNotEmpty()) {
                authViewModel.authenticateWithId(user_id_input.text.toString().toInt())
            }
        }
    }

    private fun subscribeObserver() {
        authViewModel.observeUser().observe(this, Observer {
            it?.let {
                when (it) {
                    is AuthState.Loading -> {
                        showProgressBar(true)
                    }
                    is AuthState.Login -> {
                        showProgressBar(false)
                        Log.d("TESTING", "USER:${it.data}")
                        loginUser()
                    }
                    is AuthState.Error -> {
                        showProgressBar(false)
                        Log.d("TESTING", "Invalid User")
                    }
                    is AuthState.Logout -> {
                        showProgressBar(false)
                    }
                }
            }
        })
    }

    private fun showProgressBar(isVisible: Boolean) {
        progress_bar.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    private fun loginUser() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun setLogo() {
        requestManager.load(appIcon).into(findViewById(R.id.login_logo))
    }
}