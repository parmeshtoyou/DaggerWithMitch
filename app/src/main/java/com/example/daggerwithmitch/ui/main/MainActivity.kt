package com.example.daggerwithmitch.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.daggerwithmitch.BaseActivity
import com.example.daggerwithmitch.R
import com.example.daggerwithmitch.ui.main.posts.PostsFragment
import com.example.daggerwithmitch.ui.main.profile.ProfileFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //showProfileFragment()
        showPostFragment()
    }

    private fun showPostFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, PostsFragment())
            .commit()
    }

    private fun showProfileFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, ProfileFragment())
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.logout) {
            sessionManager.logout()
        }
        return super.onOptionsItemSelected(item)
    }
}