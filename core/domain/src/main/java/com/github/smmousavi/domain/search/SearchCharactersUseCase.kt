package com.github.smmousavi.domain.search

import androidx.paging.PagingData
import com.github.smmousavi.model.Character
import kotlinx.coroutines.flow.Flow

interface SearchCharactersUseCase {
    suspend operator fun invoke(
        query: String,
        pageSize: Int = 20,
    ): Flow<PagingData<Character>>
}