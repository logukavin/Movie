package com.example.movie.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.movie.model.ContentItem
import com.example.movie.repository.DataRepository
import com.example.movie.ui.MovieListActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(private val repository: DataRepository) : ViewModel() {


    fun getMovieList(mContext: MovieListActivity): Flow<PagingData<ContentItem>> {
        return repository.getAllMovies(viewModelScope,mContext).cachedIn(viewModelScope)
    }


}