package com.github.smmousavi.network.retrofit.apiservice

import com.github.smmousavi.network.retrofit.response.SearchedCharactersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchedCharacterApiService {

    @GET("people/")
    suspend fun searchCharacter(
        @Query("search") query: String,
        @Query("page") page: Int,
    ): SearchedCharactersResponse
}