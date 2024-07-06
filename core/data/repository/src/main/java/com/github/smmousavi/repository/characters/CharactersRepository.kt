package com.github.smmousavi.repository.characters

import androidx.paging.PagingData
import com.github.smmousavi.common.result.Result
import com.github.smmousavi.model.Character
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {

    fun  getCharactersPaging(pageSize: Int): Flow<Result<Flow<PagingData<Character>>>>

    fun getCharacterById(id: String): Flow<Result<Character?>>

}