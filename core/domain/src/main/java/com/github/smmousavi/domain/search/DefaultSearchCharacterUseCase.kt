package com.github.smmousavi.domain.search

import androidx.paging.PagingData
import com.github.smmousavi.common.result.Result
import com.github.smmousavi.model.Character
import com.github.smmousavi.repository.characters.CharactersRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class DefaultSearchCharacterUseCase @Inject constructor(private val charactersRepository: CharactersRepository) :
    SearchCharactersUseCase {
    override suspend fun invoke(): Flow<Result<Flow<PagingData<Character>>>> =
        charactersRepository.getCharactersPaging(20)
}