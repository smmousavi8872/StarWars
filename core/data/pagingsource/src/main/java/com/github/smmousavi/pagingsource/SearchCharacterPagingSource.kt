package com.github.smmousavi.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.apollographql.apollo3.ApolloClient
import com.github.smmousavi.model.Character

//class SearchCharacterPagingSource(
//    private val apolloClient: ApolloClient,
//    private val searchQuery: String,
//) : PagingSource<Int, Character>() {
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
//        val page = params.key ?: 1
//        try {
////            val response = apolloClient.query(SearchPeopleQuery(searchQuery)).await()
////            val results = response.data?.allPeople?.people?.map { person ->
////                Person(
////                    name = person.name,
////                    height = person.height,
////                    mass = person.mass,
////                    gender = person.gender,
////                    homeworld = person.homeworld?.name ?: "Unknown"
////                )
////            } ?: emptyList()
//
//            return LoadResult.Page(
//                data = results,
//                prevKey = if (page > 1) page - 1 else null,
//                nextKey = if (results.isNotEmpty()) page + 1 else null
//            )
//        } catch (exception: Exception) {
//            return LoadResult.Error(exception)
//        }
//    }
//
//    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
//        return state.anchorPosition
//    }
//}