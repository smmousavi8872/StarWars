package com.github.smmousavi.domain

import androidx.paging.PagingData
import com.github.smmousavi.common.result.Result
import com.github.smmousavi.model.Character
import kotlinx.coroutines.flow.Flow

interface GetCharactersUseCase {
    suspend operator fun invoke(): Flow<Result<Flow<PagingData<Character>>>>
}