package com.github.smmousavi.datasource.film.remote

import com.apollographql.apollo3.api.ApolloResponse
import com.github.smmousavi.network.OnNewFilmsSubscription
import kotlinx.coroutines.flow.Flow

interface FilmRemoteDataSource {

    suspend fun onNewFilmsSubscription(): Flow<ApolloResponse<OnNewFilmsSubscription.Data>>

}