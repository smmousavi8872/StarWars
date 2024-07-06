package com.github.smmousavi.datasource.searchcharacter.remote

import com.github.smmousavi.network.retrofit.apiservice.SearchedCharacterApiService
import com.github.smmousavi.network.retrofit.response.SearchedCharactersResponse
import javax.inject.Inject

class DefaultSearchCharacterRemoteDataSource @Inject constructor(
    private val searchedCharacterApiService: SearchedCharacterApiService,
) : SearchCharacterRemoteDataSource {

    override suspend fun searchCharacter(
        searchQuery: String,
        page: Int,
    ): SearchedCharactersResponse {
        return searchedCharacterApiService.searchCharacter(searchQuery, page)
    }
}