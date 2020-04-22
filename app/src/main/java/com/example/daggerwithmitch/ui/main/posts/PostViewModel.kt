package com.example.daggerwithmitch.ui.main.posts

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.daggerwithmitch.SessionManager
import com.example.daggerwithmitch.network.main.MainApi
import javax.inject.Inject

class PostViewModel @Inject constructor(mainApi: MainApi, sessionManager: SessionManager) :
    ViewModel() {

    init {
        Log.d("TESTING-PARAM", "Post view model is ready...")
    }
}