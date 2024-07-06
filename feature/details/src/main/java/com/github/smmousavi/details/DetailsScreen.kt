package com.github.smmousavi.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.github.smmousavi.common.result.Result
import com.github.smmousavi.ui.CharacterDetailsItem
import com.github.smmousavi.ui.LoadingWheel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    characterId: String,
    navController: NavHostController,
    viewModel: CharacterDetailsViewModel = hiltViewModel(),
) {
    val characterDetailsState by viewModel.characterDetails.collectAsState()

    // Call getAllProducts() when the composable is first displayed
    LaunchedEffect(Unit) {
        viewModel.getCharacterById(characterId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Character Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBackIosNew,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->

        // Apply the padding values to the content
        Box(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            when (val result = characterDetailsState) {
                is Result.Loading -> {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        LoadingWheel("Loading...")
                    }
                }

                is Result.Success -> {
                    CharacterDetailsItem(character = result.data)
                }

                is Result.Error -> {
                    val message = result.exception.message
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = message ?: "Error occurred!")
                    }
                }
            }
        }
    }
}