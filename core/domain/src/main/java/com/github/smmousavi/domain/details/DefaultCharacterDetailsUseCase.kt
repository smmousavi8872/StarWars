package com.github.smmousavi.domain.details

import com.github.smmousavi.common.result.Result
import com.github.smmousavi.model.Character
import com.github.smmousavi.repository.characters.CharactersRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class DefaultCharacterDetailsUseCase @Inject constructor(private val charactersRepository: CharactersRepository) :
    CharacterDetailsUseCase {
    override suspend fun invoke(id: String): Flow<Result<Character>> =
        charactersRepository.getCharacterById(id)
}