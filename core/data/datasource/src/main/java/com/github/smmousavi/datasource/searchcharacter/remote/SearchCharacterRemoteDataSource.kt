package com.github.smmousavi.datasource.searchcharacter.remote

import com.github.smmousavi.network.retrofit.response.SearchedCharactersResponse

interface SearchCharacterRemoteDataSource {
    suspend fun searchCharacter(
        searchQuery: String,
        page: Int,
    ): SearchedCharactersResponse

}