package com.github.smmousavi.domain.search

import androidx.paging.PagingData
import com.github.smmousavi.model.Character
import com.github.smmousavi.repository.searchedcharacter.SearchCharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class DefaultSearchCharacterUseCase @Inject constructor(private val charactersRepository: SearchCharacterRepository) :
    SearchCharactersUseCase {
    override suspend operator fun invoke(
        query: String,
        pageSize: Int,
    ): Flow<PagingData<Character>> = charactersRepository.searchCharacter(query, pageSize)
}