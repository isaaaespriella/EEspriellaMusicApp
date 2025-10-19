package com.example.musicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.musicapp.screens.HomeScreen
import com.example.musicapp.ui.theme.AlbumDetailScreenRoute
import com.example.musicapp.ui.theme.HomeScreenRoute
import com.example.musicapp.ui.theme.MusicAppTheme
import com.example.musicapp.screens.AlbumDetailScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MusicAppTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = HomeScreenRoute,
                        modifier = Modifier.padding(innerPadding)
                    ){
                        composable<HomeScreenRoute> {
                            HomeScreen(
                                navController
                            )
                        }
                        composable<AlbumDetailScreenRoute> { backStack ->
                            val args = backStack.toRoute<AlbumDetailScreenRoute>()
                            AlbumDetailScreen(navController, args.id)
                        }
                    }
                }
            }
        }
    }
}
