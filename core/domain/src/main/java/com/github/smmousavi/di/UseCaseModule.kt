package com.github.smmousavi.domain.di

import com.github.smmousavi.domain.DefaultGetCharacterUseCase
import com.github.smmousavi.domain.GetCharactersUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindsGetCharactersUseCase(getCharactersUseCase: DefaultGetCharacterUseCase): GetCharactersUseCase

}