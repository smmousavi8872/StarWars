package com.github.smmousavi.repository.searchedcharacter

import androidx.paging.PagingData
import com.github.smmousavi.model.Character
import kotlinx.coroutines.flow.Flow


interface SearchCharacterRepository {

    fun searchCharacter(
        searchTerm: String,
        pageSize: Int,
    ): Flow<PagingData<Character>>
}