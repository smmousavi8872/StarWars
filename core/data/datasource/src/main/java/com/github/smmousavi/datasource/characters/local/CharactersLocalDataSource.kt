package com.github.smmousavi.datasource.characters.local

import com.github.smmousavi.database.entity.CharacterEntity

interface CharactersLocalDataSource {

    suspend fun insertAllCharacters(characters: List<CharacterEntity>)


}