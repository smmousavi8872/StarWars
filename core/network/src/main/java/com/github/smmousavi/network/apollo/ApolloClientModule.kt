package com.github.smmousavi.network.apollo

import com.apollographql.apollo3.ApolloClient
import com.github.smmousavi.common.Constants.GRAPHQL_BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named


@Module
@InstallIn(SingletonComponent::class)
object ApolloClientModule {

    @Provides
    @Named("Apollo")
    fun provideApolloClient() =
        ApolloClient.Builder()
            .serverUrl(GRAPHQL_BASE_URL)
            .build()

    @Provides
    @Named("WebSocket")
    fun provideApolloWebsocket() = ApolloClient.Builder()
        // Server URL for regular queries/mutations
        .serverUrl(GRAPHQL_BASE_URL)
        // Server URL for your websocket
        .webSocketServerUrl("wss://your-graphql-endpoint.com/subscriptions")
        .build()
}

