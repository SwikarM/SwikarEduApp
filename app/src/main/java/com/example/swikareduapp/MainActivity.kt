package com.example.swikareduapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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

}

@Composable
fun SettingScreen(navController: NavHostController, modifier: Modifier = Modifier) {
}

@Composable
fun GameScreen(navController: NavHostController, modifier: Modifier = Modifier) {
}

@Composable
fun ScoreScreen(navController: NavHostController, modifier: Modifier = Modifier) {
}


@Preview(showBackground = true)
@Composable
fun AppNavPreview() {
    SwikarEduAppTheme {
        AppNav()
    }
}