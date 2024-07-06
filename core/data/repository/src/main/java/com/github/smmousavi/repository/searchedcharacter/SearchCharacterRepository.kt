package com.github.smmousavi.repository.searchedcharacter

import androidx.paging.PagingData
import com.github.smmousavi.common.result.Result
import com.github.smmousavi.model.Character
import kotlinx.coroutines.flow.Flow

interface SearchCharacterRepository {

    fun searchCharacter(
        searchTerm: String,
        pageSize: Int,
    ): Flow<Result<Flow<PagingData<Character>>>>
}