package com.github.smmousavi.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.smmousavi.common.result.Result
import com.github.smmousavi.domain.details.CharacterDetailsUseCase
import com.github.smmousavi.model.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(val detailsUseCase: CharacterDetailsUseCase) :
    ViewModel() {

    private val _characterDetails = MutableStateFlow<Result<Character>>(Result.Loading)
    val characterDetails: StateFlow<Result<Character>> = _characterDetails

    fun getCharacterById(id: String) {
        viewModelScope.launch {
            detailsUseCase.invoke(id).collect { result ->
                _characterDetails.value = result
            }
        }
    }

}