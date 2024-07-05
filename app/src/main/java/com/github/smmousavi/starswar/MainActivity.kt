package com.github.smmousavi.starswar

import HomeScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.smmousavi.ui.theme.StarsWarTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StarsWarTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "store") {
                    composable("store") { HomeScreen(navController) }
                }
            }
        }
    }
}
