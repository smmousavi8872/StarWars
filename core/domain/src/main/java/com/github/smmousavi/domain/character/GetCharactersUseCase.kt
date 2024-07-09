package com.github.smmousavi.domain.character

import androidx.paging.PagingData
import com.github.smmousavi.model.Character
import kotlinx.coroutines.flow.Flow

interface GetCharactersUseCase {
    suspend operator fun invoke(pageSize: Int = 20): Flow<PagingData<Character>>
}