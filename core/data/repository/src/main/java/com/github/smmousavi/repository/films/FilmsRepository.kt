package com.github.smmousavi.repository.films

import com.github.smmousavi.common.result.Result
import com.github.smmousavi.network.OnNewFilmsSubscription
import kotlinx.coroutines.flow.Flow

interface FilmsRepository {

    suspend fun subscribeOnNewFilms(): Flow<Result<List<OnNewFilmsSubscription.Film?>?>>

}