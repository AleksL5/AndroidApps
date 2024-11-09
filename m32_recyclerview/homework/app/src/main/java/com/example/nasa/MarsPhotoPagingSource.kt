package com.example.nasa

import androidx.paging.PagingSource
import androidx.paging.PagingState
import java.io.IOException
import retrofit2.HttpException


class MarsPhotoPagingSource(
    private val apiService: MarsApiService,
    private val apiKey: String
) : PagingSource<Int, MarsPhoto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MarsPhoto> {
        val page = params.key ?: 1
        return try {
            val response = apiService.getPhotos(apiKey, page)
            LoadResult.Page(
                data = response.photos,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.photos.isEmpty()) null else page + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, MarsPhoto>): Int? {
        return state.anchorPosition?.let { state.closestPageToPosition(it)?.prevKey }
    }
}