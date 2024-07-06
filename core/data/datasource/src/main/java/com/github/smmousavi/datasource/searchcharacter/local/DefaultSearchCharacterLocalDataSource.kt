package com.github.smmousavi.datasource.searchcharacter.local

import com.github.smmousavi.database.dao.SearchCharacterDao
import com.github.smmousavi.database.entity.CharacterEntity
import javax.inject.Inject

class DefaultSearchCharacterLocalDataSource @Inject constructor(private val characterDao: SearchCharacterDao) :
    SearchCharacterLocalDataSource {
    override suspend fun insertSearchedCharacters(characters: List<CharacterEntity>) {
        characterDao.updateSearchedCharacter(characters)
    }
}