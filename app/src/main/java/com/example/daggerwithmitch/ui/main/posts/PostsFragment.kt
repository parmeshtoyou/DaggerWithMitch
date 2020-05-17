package com.example.daggerwithmitch.ui.main.posts

import androidx.fragment.app.Fragment

class PostsFragment: Fragment() {

    /*@Inject
    lateinit var postsAdapter: PostsAdapter

    @Inject
    lateinit var authViewModelFactory: AuthViewModelFactory

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var postViewModel: PostViewModel

    private lateinit var progressBar : ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.posts_fragment, container, false)
        progressBar = view.findViewById(R.id.progress_bar)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        *//*recycler_view.apply {
            layoutManager = linearLayoutManager
            adapter = postsAdapter
        }*//*
        postViewModel = ViewModelProvider(this, authViewModelFactory)[PostViewModel::class.java]

        observePosts()
    }

    private fun observePosts() {
        postViewModel.observePosts().removeObservers(this)
        postViewModel.observePosts().observe(viewLifecycleOwner, Observer {
            when(it) {
                is Resource.Success -> {
                    showProgress()
                   postsAdapter.setPosts(it.data!!)
                }
                is Resource.Failed -> {
                    showProgress()
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> showProgress(true)
            }
        })
    }

    private fun showProgress(visibility: Boolean = false) {
        progressBar.visibility = if (visibility) View.VISIBLE else View.GONE
    }*/
}