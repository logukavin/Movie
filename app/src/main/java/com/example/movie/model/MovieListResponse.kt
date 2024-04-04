package com.example.movie.model

import com.google.gson.annotations.SerializedName

const val NETWORK_PAGE_SIZE = 20

data class MovieListResponse(

	@field:SerializedName("page")
	val page: Page? = null
)

data class ContentItems(

	@field:SerializedName("content")
	val content: List<ContentItem?>? = null
)

data class ContentItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("poster-image")
	val posterImage: String? = null
)

data class Page(

	@field:SerializedName("page-num")
	val pageNum: String? = null,

	@field:SerializedName("page-size")
	val pageSize: String? = null,

	@field:SerializedName("content-items")
	val contentItems: ContentItems? = null,

	@field:SerializedName("total-content-items")
	val totalContentItems: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)
