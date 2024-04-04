package com.example.movie.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.movie.model.ContentItem
import com.example.movie.remote.SampleData
import com.example.movie.ui.MovieListActivity

class MoviePagingSource(
    private val mContexts: MovieListActivity
) : PagingSource<Int, ContentItem>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ContentItem> {

        return try {
            val position = params.key ?: 1
            val response = SampleData.getMovieList(mContexts, position)
            LoadResult.Page(
                data = response.page!!.contentItems!!.content as List<ContentItem>,
                prevKey = if (position == 1) null else position - 1,
                nextKey = position + 1
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }


    override fun getRefreshKey(state: PagingState<Int, ContentItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

}
