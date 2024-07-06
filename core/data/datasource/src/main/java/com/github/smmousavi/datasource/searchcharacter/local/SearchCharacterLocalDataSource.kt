package com.github.smmousavi.datasource.searchcharacter.local

import com.github.smmousavi.database.entity.CharacterEntity

interface SearchCharacterLocalDataSource {

    suspend fun insertSearchedCharacters(characters: List<CharacterEntity>)

}