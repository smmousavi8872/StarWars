package com.github.smmousavi.starswar

import HomeScreen
import SearchScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.smmousavi.common.Constants.DETAILS_SCREEN_ARGS_KEY
import com.github.smmousavi.common.Constants.DETAILS_SCREEN_ROUT
import com.github.smmousavi.common.Constants.HOME_SCREEN_ROUT
import com.github.smmousavi.common.Constants.SEARCH_SCREEN_ROUT
import com.github.smmousavi.details.DetailsScreen


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HOME_SCREEN_ROUT) {
        composable(HOME_SCREEN_ROUT) {
            HomeScreen(navController)
        }
        composable(SEARCH_SCREEN_ROUT) {
            SearchScreen(navController)
        }
        composable("$DETAILS_SCREEN_ROUT/{$DETAILS_SCREEN_ARGS_KEY}") { backStackEntry ->
            DetailsScreen(
                characterId = backStackEntry.arguments?.getString(DETAILS_SCREEN_ARGS_KEY) ?: "",
                navController
            )
        }
    }
}