
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.github.smmousavi.common.Constants.DETAILS_SCREEN_ROUT
import com.github.smmousavi.common.result.Result
import com.github.smmousavi.search.SearchScreenViewModel
import com.github.smmousavi.ui.CharacterList
import com.github.smmousavi.ui.LoadingWheel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    navController: NavHostController,
    viewModel: SearchScreenViewModel = hiltViewModel(),
) {
    val searchQuery by viewModel.searchQuery.collectAsState()
    val searchResult by viewModel.searchResult.collectAsState(initial = Result.Loading)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Search Characters") },
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
        Box(modifier = Modifier.padding(paddingValues)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                TextField(
                    value = searchQuery,
                    onValueChange = { query -> viewModel.searchCharacter(query) },
                    label = { Text("Search Characters") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                if (searchQuery.isNotEmpty()) {
                    when (val result = searchResult) {
                        Result.Loading -> {
                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.TopCenter
                            ) {
                                LoadingWheel(contentDesc = "Loading ...")
                            }
                        }

                        is Result.Success -> {
                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.TopCenter
                            ) {
                                val lazyPagingItems = result.data.collectAsLazyPagingItems()
                                CharacterList(characters = lazyPagingItems) { id ->
                                    navController.navigate("$DETAILS_SCREEN_ROUT/{$id}")
                                }
                            }
                        }

                        is Result.Error -> {
                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.TopCenter
                            ) {
                                Text("Error: ${result.exception.message}")
                            }
                        }
                    }
                } else {
                    Text(
                        "Search your character name",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }


    }
}



