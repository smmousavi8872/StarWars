package com.github.smmousavi.repository.characters

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.github.smmousavi.asEntity
import com.github.smmousavi.asExternalModel
import com.github.smmousavi.common.result.Result
import com.github.smmousavi.datasource.characters.local.CharactersLocalDataSource
import com.github.smmousavi.datasource.characters.remote.CharactersRemoteDataSource
import com.github.smmousavi.pagingsource.CharactersPagingSource
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DefaultCharactersRepository @Inject constructor(
    private val localDataSource: CharactersLocalDataSource,
    private val remoteDataSource: CharactersRemoteDataSource,
) : CharactersRepository {

    override fun getCharactersPaging(pageSize: Int) = Pager(
        config = PagingConfig(
            pageSize = pageSize,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            CharactersPagingSource { first, after ->
                val response = remoteDataSource.getAllCharacters(first, after)

                localDataSource.insertAllCharacters(
                    response.data?.allPeople?.people?.map {
                        it.asEntity()
                    } ?: emptyList())

                response.data?.allPeople?.people?.map {
                    it.asExternalModel()
                } ?: emptyList()
            }
        }
    ).flow

    override fun getCharacterById(id: String) = flow {
        emit(Result.Loading)
        val character = remoteDataSource.getCharacterById(id)
            .data
            ?.person
            .asExternalModel()
        emit(Result.Success(character))
    }
        .catch { e -> emit(Result.Error(e)) }
}