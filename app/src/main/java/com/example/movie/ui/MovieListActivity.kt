package com.example.movie.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.filter
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movie.adapter.MoviePagerAdapter
import com.example.movie.base.BaseActivity
import com.example.movie.databinding.ActivityMovieBinding
import com.example.movie.model.ContentItem
import com.example.movie.viewmodel.MovieListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MovieListActivity : BaseActivity<ActivityMovieBinding>(), TextWatcher {

    private lateinit var movieListViewModel: MovieListViewModel
    private lateinit var gridLayoutManager: GridLayoutManager
    private val moviePagerAdapter = MoviePagerAdapter()
    private var pagingData: PagingData<ContentItem>? = null


    override fun inflateViewBinding(inflater: LayoutInflater): ActivityMovieBinding =
        ActivityMovieBinding.inflate(inflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieListViewModel = ViewModelProvider(this)[MovieListViewModel::class.java]

        val orientation = resources.configuration.orientation
        gridLayoutManager = if (orientation == 2) {
            GridLayoutManager(this, 7) // Set column count for landscape mode
        } else {
            GridLayoutManager(this, 3) // Set initial column count for portrait mode
        }
        binding.rvMovie.layoutManager = gridLayoutManager
        binding.rvMovie.adapter = moviePagerAdapter
        binding.etSearch.addTextChangedListener(this)

        moviePagerAdapter.addLoadStateListener { loadState ->
            if (loadState.refresh is LoadState.Loading ||
                loadState.append is LoadState.Loading
            )
                binding.progress.isVisible = true
            else {
                binding.progress.isVisible = false
                // If we have an error, show a toast
                val errorState = when {
                    loadState.append is LoadState.Error -> loadState.append as LoadState.Error
                    loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
                    loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
                    else -> null
                }
                errorState?.let {
                }

            }
        }

        initMovieList()

        binding.imgSearch.setOnClickListener {
            binding.ctHeader.isVisible = false
            binding.imgClose.isVisible = false
            binding.ctSearch.isVisible = true
        }
        binding.imgClose.setOnClickListener {
            binding.etSearch.text!!.clear()
            binding.imgClose.isVisible = false
        }
        binding.imgBack.setOnClickListener {
            finish()
        }

    }


    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(name: CharSequence?, start: Int, before: Int, count: Int) {
        binding.imgClose.isVisible = true
        if (name!!.isEmpty()) {
            binding.imgClose.isVisible = false
            initMovieList()
            return
        }

        if (name.length >= 3) {
            moviePagerAdapter.submitData(
                lifecycle,
                pagingData!!.filter {
                    it.name!!.lowercase().contains(name.trim().toString().lowercase())
                })
        }
    }

    override fun afterTextChanged(s: Editable?) {

    }

    private fun initMovieList() {
        lifecycleScope.launch {
            movieListViewModel.getMovieList(this@MovieListActivity).collectLatest {
                pagingData = it
                it.let { moviePagerAdapter.submitData(lifecycle, it) }
            }
        }
    }
}