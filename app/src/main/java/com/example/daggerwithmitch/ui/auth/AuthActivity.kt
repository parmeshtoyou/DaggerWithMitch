package com.example.daggerwithmitch.ui.auth

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.example.daggerwithmitch.R
import com.example.daggerwithmitch.di.ViewModelFactoryModule
import com.example.daggerwithmitch.network.auth.AuthApi
import com.example.daggerwithmitch.viewmodel.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.schedulers.Schedulers
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

        login_button.setOnClickListener {
            val userId = user_id_input.text.toString().toInt()
            authViewModel.fetchUser(userId)
        }
    }

    private fun setLogo() {
        requestManager.load(appIcon).into(findViewById(R.id.login_logo))
    }
}