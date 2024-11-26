package com.example.carrentalapp.router

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.carrentalapp.screens.Detail
import com.example.carrentalapp.screens.LoginScreen
import com.example.carrentalapp.screens.SignUpScreen
import com.example.carrentalapp.screens.user.HomeScreen

@Composable
fun Router() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(
                onSignUpClick = {
                    navController.navigate("signup")
                }, onAuth = {
                    navController.navigate("home screen")
                }
            )
        }
        composable("signup") {
            SignUpScreen(
                onLoginClick = {
                    navController.navigate("login")
                }, onAuth = {
                    navController.navigate("home screen")
                }
            )
        }

        composable("home screen") {
            HomeScreen(navController)
        }

        composable(
            "detail/{id}", arguments = listOf(navArgument("id") {
                type = NavType.IntType
            }),
        )  {
            backStackEntry ->
            val id=backStackEntry.arguments?.getInt("id")

            if (id != null) {
                Detail(id = id)
            }
        }
    }
}