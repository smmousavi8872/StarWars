package com.github.smmousavi.datasource.film.remote

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.exception.ApolloException
import com.github.smmousavi.network.FilmQuery
import javax.inject.Inject

class DefaultFilmRemoteDataSource @Inject constructor(private val apolloClient: ApolloClient) :
    FilmRemoteDataSource {

    override suspend fun handleErrorResponse(id: String) {
        try {
            val response = apolloClient.query(FilmQuery(id)).execute()
            if (response.hasErrors()) {
                response.errors?.forEach { error ->
                    println("Error: ${error.message}")
                }
            } else {
                val film = response.data?.film
                println("film title: ${film?.title}")
            }
        } catch (e: ApolloException) {
            println("Network error: ${e.message}")
        }
    }
}