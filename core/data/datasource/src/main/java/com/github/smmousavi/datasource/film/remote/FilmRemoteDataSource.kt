package com.github.smmousavi.datasource.film.remote

internal interface FilmRemoteDataSource {

    suspend fun handleErrorResponse(id: String)

}