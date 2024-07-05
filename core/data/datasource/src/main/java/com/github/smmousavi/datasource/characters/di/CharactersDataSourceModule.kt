package com.github.smmousavi.datasource.characters.di

import com.github.smmousavi.datasource.characters.local.CharactersLocalDataSource
import com.github.smmousavi.datasource.characters.local.DefaultCharactersLocalDataSource
import com.github.smmousavi.datasource.characters.remote.CharactersRemoteDataSource
import com.github.smmousavi.datasource.characters.remote.DefaultCharactersRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class CharactersDataSourceModule {

    @Binds
    abstract fun bindsLocalDataSource(localDataSource: DefaultCharactersLocalDataSource): CharactersLocalDataSource

    @Binds
    abstract fun bindsRemoteDataSource(remoteDataSource: DefaultCharactersRemoteDataSource): CharactersRemoteDataSource
}