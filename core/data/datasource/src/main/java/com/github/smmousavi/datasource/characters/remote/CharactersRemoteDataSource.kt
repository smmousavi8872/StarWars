package com.github.smmousavi.datasource.characters.remote

import com.apollographql.apollo3.api.ApolloResponse
import com.github.smmousavi.network.PeopleQuery
import com.github.smmousavi.network.PersonQuery

 interface CharactersRemoteDataSource {
    suspend fun getAllCharacters(): ApolloResponse<PeopleQuery.Data>

    suspend fun getCharacterById(id: String): ApolloResponse<PersonQuery.Data>

}