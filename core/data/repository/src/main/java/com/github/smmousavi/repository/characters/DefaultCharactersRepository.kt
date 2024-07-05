package com.github.smmousavi.repository.characters

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.github.smmousavi.common.network.AppDispatchers
import com.github.smmousavi.common.network.Dispatcher
import com.github.smmousavi.common.result.Result
import com.github.smmousavi.datasource.characters.local.CharactersLocalDataSource
import com.github.smmousavi.datasource.characters.remote.CharactersRemoteDataSource
import com.github.smmousavi.model.Character
import com.github.smmousavi.pagingsource.CharactersPagingSource
import com.github.smmousavi.repository.asExternalModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DefaultCharactersRepository @Inject constructor(
    private val localDataSource: CharactersLocalDataSource,
    private val remoteDataSource: CharactersRemoteDataSource,
    @Dispatcher(AppDispatchers.IO) val ioDispatcher: CoroutineDispatcher,
) : CharactersRepository {

    override suspend fun getCharactersStream() = Pager(
        config = PagingConfig(pageSize = 20, enablePlaceholders = false),
        pagingSourceFactory = { CharactersPagingSource(localDataSource, remoteDataSource) }
    ).flow


    override suspend fun getCharacterById(id: String) = flow {
        emit(Result.Loading)
        val character = remoteDataSource.getCharacterById(id)
            .data
            ?.person
            ?.asExternalModel()
        emit(Result.Success(character))
    }
        .catch { e -> emit(Result.Error(e)) }
}