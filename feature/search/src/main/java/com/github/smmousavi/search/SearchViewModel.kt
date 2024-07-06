package com.github.smmousavi.search

import androidx.lifecycle.ViewModel
import com.github.smmousavi.domain.search.SearchCharactersUseCase
import com.github.smmousavi.model.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchProductsUseCase: SearchCharactersUseCase,
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> get() = _searchQuery

    private val _searchResults = MutableStateFlow<List<Character>>(emptyList())
    val searchResults: StateFlow<List<Character>> get() = _searchResults

    fun searchProducts() {
//        viewModelScope.launch {
//            _searchQuery
//                .debounce(300)
//                .distinctUntilChanged()
//                .flatMapLatest { query ->
//                    if (query.isEmpty()) {
//                        flowOf(emptyList())
//                    } else {
//                        searchProductsUseCase.invoke(query)
//                    }
//                }
//                .collect { results ->
//                    _searchResults.value = results
//                }
//        }
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }
}