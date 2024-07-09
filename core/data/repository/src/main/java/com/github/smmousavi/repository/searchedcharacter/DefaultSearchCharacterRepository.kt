package com.github.smmousavi.repository.searchedcharacter

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.github.smmousavi.asEntity
import com.github.smmousavi.common.network.AppDispatchers
import com.github.smmousavi.common.network.Dispatcher
import com.github.smmousavi.datasource.searchcharacter.local.DefaultSearchCharacterLocalDataSource
import com.github.smmousavi.datasource.searchcharacter.remote.DefaultSearchCharacterRemoteDataSource
import com.github.smmousavi.model.Character
import com.github.smmousavi.pagingsource.SearchCharacterPagingSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefaultSearchCharacterRepository @Inject constructor(
    private val remoteDataSource: DefaultSearchCharacterRemoteDataSource,
    private val localDataSource: DefaultSearchCharacterLocalDataSource,
    @Dispatcher(AppDispatchers.IO) val ioDispatcher: CoroutineDispatcher,
) : SearchCharacterRepository {

    private val repositoryScope = CoroutineScope(ioDispatcher + SupervisorJob())


    override suspend fun searchCharacter(
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
        .cachedIn(repositoryScope)
}
