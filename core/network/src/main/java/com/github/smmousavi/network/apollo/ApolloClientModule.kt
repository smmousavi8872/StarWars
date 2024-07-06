package com.github.smmousavi.network.apollo

import com.apollographql.apollo3.ApolloClient
import com.github.smmousavi.common.Constants.GRAPHQL_BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object ApolloClientModule {

    @Provides
    fun provideApolloClient() =
        ApolloClient.Builder()
            .serverUrl(GRAPHQL_BASE_URL)
            .build()
}

