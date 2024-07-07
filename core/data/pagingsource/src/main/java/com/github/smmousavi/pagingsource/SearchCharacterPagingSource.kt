package com.github.smmousavi.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.smmousavi.asExternalModel
import com.github.smmousavi.model.Character
import com.github.smmousavi.network.retrofit.response.SearchedCharactersResponse

class SearchCharacterPagingSource(
    private val searchRequest: suspend (nextPage: Int) -> SearchedCharactersResponse,
) : PagingSource<Int, Character>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return try {
            val nextPage = params.key ?: 1
            val response = searchRequest(nextPage)
            LoadResult.Page(
                data = response.results.map { char -> char.asExternalModel() },
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (response.next == null) null else nextPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition
    }
}