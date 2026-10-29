@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.swikareduapp

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.swikareduapp.ui.theme.SwikarEduAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SwikarEduAppTheme {
                AppNav()
            }
        }
    }
}
@Composable
fun AppNav(modifier: Modifier = Modifier){

    //obtain navController
    val navController = rememberNavController()

    //set up NavHost and routes
    NavHost(navController, startDestination = "Landing") {

        //Define the home route
        composable(route = "Landing") {
            LandingScreen(navController) }
        //Define the setting route
        composable(route = "setting") {
            SettingScreen(navController)}
        //Define the game route
        composable(route = "game") {
            GameScreen(navController)}
        //Define the score route
        composable(route = "Score") {
            ScoreScreen(navController)}

    }

}
@Composable

fun LandingScreen(navController: NavHostController, modifier: Modifier = Modifier) {

    Scaffold(
        topBar = { TopAppBar(title = { Text("Landing Screen") }) }

    ) {
        innerPadding ->
        Column(modifier

            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp)) {
            Button(onClick = {navController.navigate("setting")})
            { Text("Go to setting") }

        }

    }

}

@Composable
fun SettingScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Setting Screen") }) }

    ) {
            innerPadding ->
        Column(modifier

            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp)) {
            Button(onClick = {navController.navigate("game")})
            { Text("Go to game") }

        }

    }

}

@Composable
fun GameScreen(navController: NavHostController, modifier: Modifier = Modifier) {

    Scaffold(
        topBar = { TopAppBar(title = { Text("Game Screen") }) }

    ) {
            innerPadding ->
        Column(modifier

            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp)) {
            Button(onClick = {navController.navigate("score")})
            { Text("Go to score") }

        }

    }


}

@Composable
fun ScoreScreen(navController: NavHostController, modifier: Modifier = Modifier) {

    Scaffold(
        topBar = { TopAppBar(title = { Text("score Screen") }) }

    ) {
            innerPadding ->
        Column(modifier

            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp)) {
            Button(onClick = {navController.navigate("landing")})
            { Text("Go to landing") }

        }

    }


}


@Preview(showBackground = true)
@Composable
fun AppNavPreview() {
    SwikarEduAppTheme {
        AppNav()
    }
}