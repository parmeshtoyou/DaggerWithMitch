package com.example.daggerwithmitch.ui.auth

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.example.daggerwithmitch.R
import com.example.daggerwithmitch.models.User
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
                when (it.authStatus) {
                    AuthStatus.LOADING -> {
                        showProgressBar(true)
                    }
                    AuthStatus.AUTHENTICATED -> {
                        showProgressBar(false)
                        Log.d("TESTING", "USER:${it.data}")
                        gotoMainScreen(it.data)
                    }
                    AuthStatus.ERROR -> {
                        showProgressBar(false)
                        Log.d("TESTING", "Invalid User")
                    }
                    AuthStatus.NOT_AUTHENTICATED -> {
                        showProgressBar(false)
                    }
                }
            }
        })
    }

    private fun showProgressBar(isVisible: Boolean) {
        progress_bar.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    private fun gotoMainScreen(data: User?) {

    }

    private fun setLogo() {
        requestManager.load(appIcon).into(findViewById(R.id.login_logo))
    }
}