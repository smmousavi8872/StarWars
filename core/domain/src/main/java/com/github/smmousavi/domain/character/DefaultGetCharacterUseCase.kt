package com.github.smmousavi.domain.character

import androidx.paging.PagingData
import com.github.smmousavi.common.result.Result
import com.github.smmousavi.model.Character
import com.github.smmousavi.repository.characters.CharactersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DefaultGetCharacterUseCase @Inject constructor(private val charactersRepository: CharactersRepository) :
    GetCharactersUseCase {
    override suspend fun invoke(): Flow<Result<Flow<PagingData<Character>>>> = flow {
        emit(Result.Loading)
        try {
            val response = charactersRepository.getCharactersPaging(20)
            emit(Result.Success(response))
        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }
}

