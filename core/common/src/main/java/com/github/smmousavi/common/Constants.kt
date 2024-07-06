package com.github.smmousavi.common

object Constants {

    const val TAG = "LOG_TAG"

    // Base Urls
    const val REST_BASE_URL = "https://swapi.dev/api/"
    const val GRAPHQL_BASE_URL = "https://swapi-graphql.netlify.app/.netlify/functions/index"

    // Navigation
    const val HOME_SCREEN_ROUT = "homeScreen"
    const val SEARCH_SCREEN_ROUT = "searchScreen"
    const val DETAILS_SCREEN_ROUT = "detailsScreen/{characterId}"
    const val DETAILS_SCREEN_ARGS_KEY = "characterId"

    // Hilt Named()
    const val OK_HTTP_FACTORY = "OkHttpFactory"
    const val OK_HTTP_CLIENT = "OkHttpClient"
}