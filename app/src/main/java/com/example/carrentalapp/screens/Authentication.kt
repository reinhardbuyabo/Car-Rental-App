package com.example.carrentalapp.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.carrentalapp.screens.LoginScreen
import com.example.carrentalapp.screens.SignUpScreen

@Composable
fun AuthenticationScreen() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(
                onSignUpClick = {
                    navController.navigate("signup")
                }
            )
        }
        composable("signup") {
            SignUpScreen(
                onLoginClick = {
                    navController.navigate("login")
                }
            )
        }
    }
}