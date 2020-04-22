package com.example.daggerwithmitch

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.daggerwithmitch.ui.auth.AuthActivity
import com.example.daggerwithmitch.ui.auth.AuthState
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity: DaggerAppCompatActivity() {

    @Inject
    protected lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeObserver()
    }

    private fun subscribeObserver() {
        sessionManager.getAuthUser().observe(this, Observer {
            it?.let {
                when (it) {
                    is AuthState.Loading -> {

                    }
                    is AuthState.Login -> {
                        Log.d("TESTING", "Base Activity USER:${it.data}")
                    }
                    is AuthState.Error -> {
                        Log.d("TESTING", "Invalid User message:${it.message}")
                    }
                    is AuthState.Logout -> {
                        gotoAuthPage()
                    }
                }
            }
        })
    }

    private fun gotoAuthPage() {
        startActivity(Intent(this, AuthActivity::class.java))
        finish()
    }
}