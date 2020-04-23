package com.example.daggerwithmitch.ui.main.posts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.daggerwithmitch.R
import com.example.daggerwithmitch.models.post.Post


class PostsAdapter: RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {

    private var posts: List<Post> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_post_list_item, parent, false)
        return PostViewHolder(view)
    }
    override fun getItemCount(): Int {
        return posts.size
    }

    fun setPosts(posts: List<Post>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.title)
        fun bind(post: Post) {
            title.text = post.title
        }
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        (holder).bind(posts[position])
    }
}