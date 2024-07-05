package com.github.smmousavi.repository.characters

import com.github.smmousavi.common.result.Result
import com.github.smmousavi.model.Character
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {

    suspend fun fetchAllCharacters(): Flow<Result<List<Character?>?>>

    suspend fun getCharacterById(id: String): Flow<Result<Character?>>

}