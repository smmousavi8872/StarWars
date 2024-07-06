package com.github.smmousavi.repository.searchedcharacter

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.github.smmousavi.common.result.Result
import com.github.smmousavi.datasource.searchcharacter.local.DefaultSearchCharacterLocalDataSource
import com.github.smmousavi.datasource.searchcharacter.remote.DefaultSearchCharacterRemoteDataSource
import com.github.smmousavi.pagingsource.SearchCharacterPagingSource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DefaultSearchCharacterRepository @Inject constructor(
    private val remoteDataSource: DefaultSearchCharacterRemoteDataSource,
    private val localDataSource: DefaultSearchCharacterLocalDataSource,
) : SearchCharacterRepository {

    override fun searchCharacter(searchTerm: String, pageSize: Int) = flow {
        emit(Result.Loading)
        try {
            val pager = Pager(
                config = PagingConfig(
                    pageSize = pageSize,
                    enablePlaceholders = false
                ),
                pagingSourceFactory = {
                    SearchCharacterPagingSource(
                        localDataSource,
                        remoteDataSource,
                        searchTerm
                    )
                }
            ).flow
            emit(Result.Success(pager))
        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }
}