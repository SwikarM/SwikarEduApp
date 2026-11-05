@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.swikareduapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.swikareduapp.ui.TestDBScreen
import com.example.swikareduapp.ui.theme.SwikarEduAppTheme

/**
 * Main Activity serving as the single-activity entry point for the application.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Enables edge-to-edge layout display for modern Android system bars
        enableEdgeToEdge()
        // Obtain application context for database operations
        val currentContext = applicationContext
        // Sets Jetpack Compose UI content
        setContent {
            SwikarEduAppTheme {
                AppNav(currentContext)
            }
        }
    }
}

/**
 * Main navigation composable managing screen transitions and routes.
 *
 * @param currentContext Context reference passed to screens needing database access.
 * @param modifier Optional modifier for UI styling.
 */
@Composable
fun AppNav(currentContext: Context, modifier: Modifier = Modifier) {
    // Obtain NavHostController to handle navigation actions
    val navController = rememberNavController()

    // Set up NavHost container with "testDB" as the start destination
    NavHost(navController = navController, startDestination = "testDB", modifier = modifier) {

        // Define the Landing screen route
        composable(route = "landing") {
            LandingScreen(navController)
        }

        // Define the Setting screen route
        composable(route = "setting") {
            SettingScreen(navController)
        }

        // Define the Game screen route
        composable(route = "game") {
            GameScreen(navController)
        }

        // Define the Score screen route
        composable(route = "score") {
            ScoreScreen(navController)
        }

        // Define the TestDB screen route
        composable(route = "testDB") {
            TestDBScreen(currentContext)
        }
    }
}

/**
 * Landing screen composable displaying initial options.
 */
@Composable
fun LandingScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Landing Screen") }) }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Button(onClick = { navController.navigate("setting") }) {
                Text("Go to setting")
            }
        }
    }
}

/**
 * Setting screen composable displaying configuration options.
 */
@Composable
fun SettingScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Setting Screen") }) }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Button(onClick = { navController.navigate("game") }) {
                Text("Go to game")
            }
        }
    }
}

/**
 * Game screen composable displaying game content.
 */
@Composable
fun GameScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Game Screen") }) }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Button(onClick = { navController.navigate("score") }) {
                Text("Go to score")
            }
        }
    }
}

/**
 * Score screen composable displaying game scores and results.
 */
@Composable
fun ScoreScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("score Screen") }) }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Button(onClick = { navController.navigate("landing") }) {
                Text("Go to landing")
            }
        }
    }
}

/**
 * Compose preview for testing AppNav layout in Android Studio.
 */
@Preview(showBackground = true)
@Composable
fun AppNavPreview() {
    SwikarEduAppTheme {
        AppNav(LocalContext.current)
    }
}
