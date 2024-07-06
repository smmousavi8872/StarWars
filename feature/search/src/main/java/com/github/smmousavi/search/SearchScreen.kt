
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.github.smmousavi.common.Constants.DETAILS_SCREEN_ROUT
import com.github.smmousavi.common.result.Result
import com.github.smmousavi.model.Character
import com.github.smmousavi.search.SearchScreenViewModel
import com.github.smmousavi.ui.CharacterList
import com.github.smmousavi.ui.LoadingWheel
import kotlinx.coroutines.flow.Flow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    navController: NavHostController,
    viewModel: SearchScreenViewModel = hiltViewModel(),
) {
    val searchQuery by viewModel.searchTerm.collectAsState()
    val searchResult by viewModel.searchResult.collectAsState(initial = Result.Loading)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Search Products") },
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
                    label = { Text("Search Products") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                if (searchQuery.isNotEmpty()) {
                    when (searchResult) {
                        Result.Loading -> {
                            LoadingWheel(contentDesc = "Loading ...")
                        }

                        is Result.Success -> {
                            val pagingDataFlow =
                                (searchResult as Result.Success<Flow<PagingData<Character>>>).data
                            val lazyPagingItems = pagingDataFlow.collectAsLazyPagingItems()

                            CharacterList(characters = lazyPagingItems) { id ->
                                navController.navigate("$DETAILS_SCREEN_ROUT/{$id}")
                            }
                        }

                        is Result.Error -> {
                            Text("Error: ${(searchResult as Result.Error).exception.message}")
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



