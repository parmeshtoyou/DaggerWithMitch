package com.example.daggerwithmitch.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.daggerwithmitch.R
import com.example.daggerwithmitch.network.auth.AuthApi
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchUserInformation(1)
    }

    private fun fetchUserInformation(userId: Int) {
        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create()).build()

        val api = retrofit.create(AuthApi::class.java)
        val disposable = api.getUser(userId)
            .toObservable()
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    Log.d("TESTING", "USER:$it")
                }, {
                    Log.d("TESTING", "ERROR:$it")
                }
            )

    }
}