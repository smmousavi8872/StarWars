package com.github.smmousavi.network.retrofit.di

import androidx.tracing.trace
import com.github.smmousavi.network.retrofit.apiservice.SearchedCharacterApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ApiServiceModule {

    @Provides
    fun provideCharactersApiService(retrofit: Retrofit): SearchedCharacterApiService {
        return trace("Trace:Retrofit") { retrofit.create(SearchedCharacterApiService::class.java) }
    }
}