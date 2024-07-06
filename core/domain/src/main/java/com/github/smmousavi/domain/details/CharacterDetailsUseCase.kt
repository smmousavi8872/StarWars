package com.github.smmousavi.domain.details

import com.github.smmousavi.common.result.Result
import com.github.smmousavi.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterDetailsUseCase {
    suspend operator fun invoke(id: String): Flow<Result<Character>>
}