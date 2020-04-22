package com.example.daggerwithmitch.ui.main.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.daggerwithmitch.R
import com.example.daggerwithmitch.viewmodel.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.posts_fragment.*
import javax.inject.Inject

class PostsFragment: DaggerFragment() {

    private lateinit var postsAdapter: PostsAdapter

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private lateinit var postViewModel: PostViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.posts_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postsAdapter = PostsAdapter()
        recycler_view.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = postsAdapter
        }

        postViewModel = ViewModelProvider(this, viewModelProviderFactory)[PostViewModel::class.java]

        fetchPosts()
    }

    private fun fetchPosts() {

    }
}