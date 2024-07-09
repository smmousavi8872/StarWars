package com.github.smmousavi.domain.character

import androidx.paging.PagingData
import com.github.smmousavi.model.Character
import com.github.smmousavi.repository.characters.CharactersRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefaultGetCharacterUseCase @Inject constructor(private val charactersRepository: CharactersRepository) :
    GetCharactersUseCase {
    override suspend fun invoke(pageSize: Int): Flow<PagingData<Character>> =
        charactersRepository.getCharactersPaging(pageSize)
}
