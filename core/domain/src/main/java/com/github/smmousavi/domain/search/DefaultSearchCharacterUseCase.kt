package com.github.smmousavi.domain.search

import androidx.paging.PagingData
import com.github.smmousavi.common.result.Result
import com.github.smmousavi.model.Character
import com.github.smmousavi.repository.searchedcharacter.SearchCharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class DefaultSearchCharacterUseCase @Inject constructor(private val charactersRepository: SearchCharacterRepository) :
    SearchCharactersUseCase {
    override suspend operator fun invoke(query: String): Flow<Result<Flow<PagingData<Character>>>> =
        flow {
            emit(Result.Loading)
            try {
                val items = charactersRepository.searchCharacter(query, 20)
                emit(Result.Success(items))
            } catch (e: Exception) {
                emit(Result.Error(e))
            }
        }
}