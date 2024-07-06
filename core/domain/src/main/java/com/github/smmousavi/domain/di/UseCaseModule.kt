package com.github.smmousavi.domain.di

import com.github.smmousavi.domain.character.DefaultGetCharacterUseCase
import com.github.smmousavi.domain.character.GetCharactersUseCase
import com.github.smmousavi.domain.details.CharacterDetailsUseCase
import com.github.smmousavi.domain.details.DefaultCharacterDetailsUseCase
import com.github.smmousavi.domain.search.DefaultSearchCharacterUseCase
import com.github.smmousavi.domain.search.SearchCharactersUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindsGetCharactersUseCase(getCharactersUseCase: DefaultGetCharacterUseCase): GetCharactersUseCase

    @Binds
    abstract fun bindsSearchCharactersUseCase(searchCharactersUseCase: DefaultSearchCharacterUseCase): SearchCharactersUseCase

    @Binds
    abstract fun bindsCharacterDetailsUseCase(characterDetailsUseCase: DefaultCharacterDetailsUseCase): CharacterDetailsUseCase

}