package com.github.smmousavi.datasource.characters.remote

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloResponse
import com.github.smmousavi.network.AllPeopleQuery
import com.github.smmousavi.network.PersonQuery
import javax.inject.Inject

class DefaultCharacterRemoteDataSource @Inject constructor(private val apolloClient: ApolloClient) :
    CharactersRemoteDataSource {

    override suspend fun getAllCharacters(
        first: Int,
        after: String,
    ): ApolloResponse<AllPeopleQuery.Data> {
        return apolloClient.query(AllPeopleQuery()).execute()
    }

    override suspend fun getCharacterById(personId: String): ApolloResponse<PersonQuery.Data> {
        return apolloClient.query(PersonQuery(personId)).execute()
    }

    override suspend fun searchCharacter(searchTerm: String): ApolloResponse<AllPeopleQuery.Data> {
        TODO("Not yet implemented")
    }
}