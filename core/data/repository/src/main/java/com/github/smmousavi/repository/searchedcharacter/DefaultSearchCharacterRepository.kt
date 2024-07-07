package com.github.smmousavi.repository.searchedcharacter

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.github.smmousavi.asEntity
import com.github.smmousavi.datasource.searchcharacter.local.DefaultSearchCharacterLocalDataSource
import com.github.smmousavi.datasource.searchcharacter.remote.DefaultSearchCharacterRemoteDataSource
import com.github.smmousavi.model.Character
import com.github.smmousavi.pagingsource.SearchCharacterPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefaultSearchCharacterRepository @Inject constructor(
    private val remoteDataSource: DefaultSearchCharacterRemoteDataSource,
    private val localDataSource: DefaultSearchCharacterLocalDataSource,
) : SearchCharacterRepository {

    override fun searchCharacter(
        searchTerm: String,
        pageSize: Int,
    ): Flow<PagingData<Character>> = Pager(
        config = PagingConfig(
            pageSize = pageSize,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            SearchCharacterPagingSource { nextPage ->
                remoteDataSource.searchCharacter(searchTerm, nextPage).also { response ->
                    localDataSource.insertSearchedCharacters(response.results.map { char -> char.asEntity() })
                }
            }
        }
    ).flow
}
