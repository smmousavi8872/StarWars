package com.github.smmousavi.repository.characters

import com.github.smmousavi.common.network.AppDispatchers
import com.github.smmousavi.common.network.Dispatcher
import com.github.smmousavi.common.result.Result
import com.github.smmousavi.datasource.characters.local.CharactersLocalDataSource
import com.github.smmousavi.datasource.characters.remote.CharactersRemoteDataSource
import com.github.smmousavi.repository.asExternalModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DefaultCharactersRepository @Inject constructor(
    private val remoteDataSource: CharactersRemoteDataSource,
    val localDataSource: CharactersLocalDataSource,
    @Dispatcher(AppDispatchers.IO) val ioDispatcher: CoroutineDispatcher,
) : CharactersRepository {

    override suspend fun fetchAllCharacters() = flow {
        emit(Result.Loading)
        val character = remoteDataSource.getAllCharacters()
            .data
            ?.allPeople
            ?.people
            ?.map { person -> person?.asExternalModel() }
        emit(Result.Success(character))
    }
        .catch { e -> emit(Result.Error(e)) }

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