import androidx.compose.foundation.layout.Box
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
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.github.smmousavi.common.Constants.DETAILS_SCREEN_ROUT
import com.github.smmousavi.common.Constants.SEARCH_SCREEN_ROUT
import com.github.smmousavi.home.HomeScreenViewModel
import com.github.smmousavi.ui.CharacterList
import com.github.smmousavi.ui.ErrorScreen
import com.github.smmousavi.ui.LoadingWheel


@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeScreenViewModel = hiltViewModel()) {
    val refreshing by viewModel.isRefreshing.collectAsState()
    val charactersResult = viewModel.characters.collectAsLazyPagingItems()

    // Call getAllCharacters() when the composable is first displayed
    LaunchedEffect(Unit) {
        viewModel.getAllCharacters()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Characters List") },
                actions = {
                    IconButton(onClick = { navController.navigate(SEARCH_SCREEN_ROUT) }) {
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
                .pullRefresh(state),
        ) {
            when (val charactersState = charactersResult.loadState.refresh) {
                is LoadState.Loading -> {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        // Show loading indicator when first loading
                        LoadingWheel(contentDesc = "Loading ...")
                    }
                }

                is LoadState.Error -> {
                    // Show error message when first loading fails
                    ErrorScreen(error = charactersState.error) { charactersResult.retry() }
                }

                else -> {
                    CharacterList(characters = charactersResult) { id ->
                        navController.navigate("$DETAILS_SCREEN_ROUT/{$id}")
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

