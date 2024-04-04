package com.example.movie.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.movie.model.ContentItem
import com.example.movie.model.NETWORK_PAGE_SIZE
import com.example.movie.paging.MoviePagingSource
import com.example.movie.ui.MovieListActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataRepository @Inject constructor() {

    /**
     * This API returns movie in realtime using which stats can be computed
     */
    fun getAllMovies(
        viewModelScope: CoroutineScope,
        mContext: MovieListActivity
    ): Flow<PagingData<ContentItem>> {
        return Pager(config = PagingConfig(
            pageSize = NETWORK_PAGE_SIZE,
            enablePlaceholders = false,
            initialLoadSize = 2
        ),
            pagingSourceFactory = { MoviePagingSource( mContext) }, initialKey = 1
        ).flow.cachedIn(viewModelScope)
    }


}
