package com.github.smmousavi.datasource.film.remote

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloResponse
import com.github.smmousavi.network.PeopleQuery
import com.github.smmousavi.network.PersonQuery
import javax.inject.Inject

class DefaultFilmRemoteDataSource @Inject constructor(private val apolloClient: ApolloClient) :
    FilmRemoteDataSource {


}