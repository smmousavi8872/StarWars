package com.github.smmousavi.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.github.smmousavi.common.result.Result
import com.github.smmousavi.domain.character.GetCharactersUseCase
import com.github.smmousavi.model.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val charactersUseCase: GetCharactersUseCase) :
    ViewModel() {

    private val _characters = MutableStateFlow<Result<Flow<PagingData<Character>>>>(Result.Loading)
    val characters: StateFlow<Result<Flow<PagingData<Character>>>> = _characters

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> get() = _isRefreshing

    fun getAllCharacters() {
        viewModelScope.launch {
            charactersUseCase.invoke()
                .collect { result ->
                    _characters.value = result
                }
        }
    }

    fun refreshHomeScreen() {
        _isRefreshing.value = true
        viewModelScope.launch {
            charactersUseCase.invoke().collect { result ->
                _characters.value = result
                _isRefreshing.value = false
            }
        }
    }
}