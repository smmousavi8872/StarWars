package com.github.smmousavi.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.github.smmousavi.common.result.Result
import com.github.smmousavi.domain.search.SearchCharactersUseCase
import com.github.smmousavi.model.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    private val searchCharacterUseCase: SearchCharactersUseCase,
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    val searchResult: Flow<Result<Flow<PagingData<Character>>>> =
        searchQuery.debounce(300)
            .distinctUntilChanged()
            .flatMapLatest { query ->
                searchCharacterUseCase.invoke(query)
            }
            .stateIn(viewModelScope, SharingStarted.Lazily, Result.Loading)

    fun searchCharacter(search: String) {
        _searchQuery.value = search
    }
}
