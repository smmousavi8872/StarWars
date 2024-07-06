package com.github.smmousavi.network.di.apollo

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import com.github.smmousavi.network.GRAPHQL_BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient

@Module
@InstallIn(SingletonComponent::class)
object ApolloClientModule {

    @Provides
    fun provideApolloClient(okHttpClient: OkHttpClient) = ApolloClient.Builder()
        .serverUrl(GRAPHQL_BASE_URL)
        .okHttpClient(okHttpClient)
        .build()
}