package com.github.smmousavi.database.di

import com.github.smmousavi.database.StarsWarDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DaosModule {

    @Provides
    fun providesCharacterDao(database: StarsWarDatabase) = database.characterDao()

    @Provides
    fun providesSearchCharacterDao(database: StarsWarDatabase) = database.searchCharacterDao()

}