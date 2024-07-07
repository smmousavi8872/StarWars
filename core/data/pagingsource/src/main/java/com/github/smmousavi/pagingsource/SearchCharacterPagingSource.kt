package com.github.smmousavi.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.smmousavi.asEntity
import com.github.smmousavi.asExternalModel
import com.github.smmousavi.datasource.searchcharacter.local.SearchCharacterLocalDataSource
import com.github.smmousavi.datasource.searchcharacter.remote.SearchCharacterRemoteDataSource
import com.github.smmousavi.model.Character

class SearchCharacterPagingSource(
    private val localDataSource: SearchCharacterLocalDataSource,
    private val remoteDataSource: SearchCharacterRemoteDataSource,
    private val searchQuery: String,
) : PagingSource<Int, Character>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return try {
            val nextPage = params.key ?: 1
            val response = remoteDataSource.searchCharacter(searchQuery, nextPage)
            localDataSource.insertSearchedCharacters(response.results.map { char -> char.asEntity() })
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

private const val TAG = "SearchCharacterPaging"