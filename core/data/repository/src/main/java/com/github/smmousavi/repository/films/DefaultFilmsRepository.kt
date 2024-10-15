package com.github.smmousavi.repository.films

import com.apollographql.apollo3.exception.ApolloException
import com.github.smmousavi.common.result.Result
import com.github.smmousavi.datasource.film.remote.FilmRemoteDataSource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DefaultFilmsRepository @Inject constructor(
    private val remoteDataSource: FilmRemoteDataSource,
) : FilmsRepository {
    override suspend fun subscribeOnNewFilms() = flow {
        emit(Result.Loading)
        remoteDataSource.onNewFilmsSubscription().collect { response ->
            if (response.hasErrors()) {
                response.errors?.forEach { error ->
                    emit(Result.Error(ApolloException(error.message)))
                }
            } else {
                emit(Result.Success(response.data?.allFilms?.films))
            }
        }
    }
}