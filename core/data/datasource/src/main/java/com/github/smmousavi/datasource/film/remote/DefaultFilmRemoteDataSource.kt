package com.github.smmousavi.datasource.film.remote


import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloResponse
import com.github.smmousavi.network.OnNewFilmsSubscription
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Named

class DefaultFilmRemoteDataSource @Inject constructor(
    @Named("WebSocket") private val apolloClient: ApolloClient,
) :
    FilmRemoteDataSource {
    override suspend fun onNewFilmsSubscription():
            Flow<ApolloResponse<OnNewFilmsSubscription.Data>> {
        return apolloClient.subscription(OnNewFilmsSubscription()).toFlow()
    }
}