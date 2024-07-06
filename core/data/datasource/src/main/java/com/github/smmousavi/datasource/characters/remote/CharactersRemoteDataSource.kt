package com.github.smmousavi.datasource.characters.remote

import com.apollographql.apollo3.api.ApolloResponse
import com.github.smmousavi.network.PeopleQuery
import com.github.smmousavi.network.PersonQuery

interface CharactersRemoteDataSource {
    suspend fun getAllCharacters(first: Int, after: String): ApolloResponse<PeopleQuery.Data>

    suspend fun getCharacterById(personId: String): ApolloResponse<PersonQuery.Data>

}