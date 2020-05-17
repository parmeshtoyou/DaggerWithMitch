package com.example.daggerwithmitch.ui.main.posts

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.daggerwithmitch.SessionManager
import com.example.daggerwithmitch.models.post.Post
import com.example.daggerwithmitch.network.main.MainApi
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostViewModel @Inject constructor(
    private val mainApi: MainApi,
    private val sessionManager: SessionManager
) :
    ViewModel() {

    init {
        Log.d("TESTING", "POST VIEW MODEL IS READY TO WORK")
    }

    private lateinit var posts: MediatorLiveData<Resource<List<Post>>>

    /*fun observePosts(): LiveData<Resource<List<Post>>> {
        if (this::posts.isInitialized.not()) {
            posts = MediatorLiveData()
            posts.value = Resource.Loading()

            val source = LiveDataReactiveStreams.fromPublisher(mainApi.getPosts(
                sessionManager.getAuthUser().value?.data?.id ?: 0
            )
                .onErrorReturn { listOf(Post(id = -1)) }
                .map { list ->
                    if (list[0].id == -1) {
                        Resource.Failed<List<Post>>("Error")
                    } else {
                        Resource.Success<List<Post>>(list)
                    }
                }
                .subscribeOn(Schedulers.io()))

            posts.addSource(source) {
                posts.value = it
                posts.removeSource(source)
            }
        }
        return posts
    }*/
}