package com.github.smmousavi.datasource.searchcharacter.di

import com.github.smmousavi.datasource.searchcharacter.local.DefaultSearchCharacterLocalDataSource
import com.github.smmousavi.datasource.searchcharacter.local.SearchCharacterLocalDataSource
import com.github.smmousavi.datasource.searchcharacter.remote.DefaultSearchCharacterRemoteDataSource
import com.github.smmousavi.datasource.searchcharacter.remote.SearchCharacterRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class SearchCharacterDataSourceModule {

    @Binds
    abstract fun bindsLocalDataSource(localDataSource: DefaultSearchCharacterLocalDataSource): SearchCharacterLocalDataSource

    @Binds
    abstract fun bindsRemoteDataSource(remoteDataSource: DefaultSearchCharacterRemoteDataSource): SearchCharacterRemoteDataSource
}