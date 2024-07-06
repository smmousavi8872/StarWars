package com.github.smmousavi.datasource.film.remote

import com.apollographql.apollo3.ApolloClient
import javax.inject.Inject

class DefaultFilmRemoteDataSource @Inject constructor(private val apolloClient: ApolloClient) :
    FilmRemoteDataSource {
}