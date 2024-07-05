package com.github.smmousavi.repository.di

import com.github.smmousavi.repository.characters.CharactersRepository
import com.github.smmousavi.repository.characters.DefaultCharactersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindRepository(repository: DefaultCharactersRepository): CharactersRepository

}