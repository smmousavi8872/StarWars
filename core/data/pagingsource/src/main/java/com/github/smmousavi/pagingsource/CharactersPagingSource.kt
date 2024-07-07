package com.github.smmousavi.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.smmousavi.model.Character

class CharactersPagingSource(
    val charactersRequest: suspend (first: Int, after: String) -> List<Character>,
) : PagingSource<Int, Character>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val position = params.key ?: 0
        return try {
            val response = charactersRequest(params.loadSize, position.toString())
            LoadResult.Page(
                data = response,
                prevKey = if (position == 0) null else position - 1,
                nextKey = if (response.isEmpty()) null else position + 1
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
