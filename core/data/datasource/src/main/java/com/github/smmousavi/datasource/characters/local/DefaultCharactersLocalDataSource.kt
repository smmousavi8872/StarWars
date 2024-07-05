package com.github.smmousavi.datasource.characters.local

import com.github.smmousavi.database.dao.CharacterDao
import com.github.smmousavi.database.entity.CharacterEntity
import javax.inject.Inject

class DefaultCharactersLocalDataSource @Inject constructor(val characterDao: CharacterDao) :
    CharactersLocalDataSource {
    override suspend fun insertAllCharacters(characters: List<CharacterEntity>) {
        characterDao.insertAllCharacters(characters)
    }
}