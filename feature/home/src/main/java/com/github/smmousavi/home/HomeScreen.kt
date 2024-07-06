import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
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
import androidx.paging.compose.collectAsLazyPagingItems
import com.github.smmousavi.common.result.Result
import com.github.smmousavi.home.HomePageViewModel
import com.github.smmousavi.ui.CharacterList
import com.github.smmousavi.ui.LoadingWheel


@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomePageViewModel = hiltViewModel()) {
    val charactersState by viewModel.characters.collectAsState()
    val refreshing by viewModel.isRefreshing.collectAsState()

    // Call getAllProducts() when the composable is first displayed
    LaunchedEffect(Unit) {
        viewModel.getAllCharacters()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Characters List") },
                actions = {
                    IconButton(onClick = { navController.navigate("search") }) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = null)
                    }
                }
            )
        }
    ) { paddingValues ->
        val state = rememberPullRefreshState(
            refreshing = refreshing,
            onRefresh = { viewModel.refreshHomeScreen() }
        )
        // Apply the padding values to the content
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .pullRefresh(state)
        ) {
            when (val result = charactersState) {
                is Result.Loading -> {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        LoadingWheel("Loading...")
                    }
                }

                is Result.Success -> {
                    val items = result.data.collectAsLazyPagingItems()
                    if (items.itemCount == 0) {
                        LoadingWheel("Loading...")
                    }
                    CharacterList(characters = items) { id ->
                        navController.navigate("details/${id}")
                    }

                }

                is Result.Error -> {
                    val message = (charactersState as Result.Error).exception.message
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(text = message ?: "Error occurred!")
                    }
                }
            }

            PullRefreshIndicator(
                refreshing = refreshing,
                state = state,
                modifier = Modifier.align(Alignment.TopCenter)
            )
        }
    }
}

