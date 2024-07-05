package com.github.smmousavi.network.di.retrofit

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object ApiServiceModule {

//    @Provides
//    fun provideCharactersApiService(retrofit: Retrofit): CharactersApiService {
//        return trace("Trace:Retrofit") { retrofit.create(CharactersApiService::class.java) }
//    }
}