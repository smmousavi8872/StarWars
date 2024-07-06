package com.github.smmousavi.starswar

import HomeScreen
import SearchScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.github.smmousavi.details.CharacterDetailsScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("search") { SearchScreen(navController) }
        composable(
            "details/{personId}",
            arguments = listOf(navArgument("personId") { type = NavType.StringType })
        ) { backStackEntry ->
            CharacterDetailsScreen(backStackEntry.arguments?.getString("characterId") ?: "")
        }
    }
}