package com.github.smmousavi.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.smmousavi.asEntity
import com.github.smmousavi.asExternalModel
import com.github.smmousavi.datasource.characters.local.CharactersLocalDataSource
import com.github.smmousavi.datasource.characters.remote.CharactersRemoteDataSource
import com.github.smmousavi.model.Character

class CharactersPagingSource(
    private val localDataSource: CharactersLocalDataSource,
    private val remoteDataSource: CharactersRemoteDataSource,
) : PagingSource<Int, Character>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val position = params.key ?: 0
        return try {
            val response = remoteDataSource.getAllCharacters(
                first = params.loadSize,
                after = position.toString()
            )
            val results = response.data?.allPeople?.people?.map {
                it.asEntity()
            } ?: emptyList()

            localDataSource.insertAllCharacters(results)
            LoadResult.Page(
                data = results.map { it.asExternalModel() },
                prevKey = if (position == 0) null else position - 1,
                nextKey = if (results.isEmpty()) null else position + 1
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
