package com.github.smmousavi.repository.characters

import androidx.paging.PagingData
import com.github.smmousavi.common.result.Result
import com.github.smmousavi.model.Character
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {

    suspend fun getCharactersPaging(pageSize: Int): Flow<PagingData<Character>>

    suspend fun getCharacterById(id: String): Flow<Result<Character>>


}