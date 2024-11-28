/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.carrentalapp.router

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.carrentalapp.ui.car.CarEntryScreen
import com.example.carrentalapp.ui.screens.Detail
import com.example.carrentalapp.ui.screens.LoginScreen
import com.example.carrentalapp.ui.screens.SignUpScreen
import com.example.carrentalapp.ui.screens.home.HomeScreen

/**
 * Provides Navigation graph for the Car Rental App.
 */
@Composable
fun Router(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login",
        modifier = modifier
    ) {
        // Login Screen
        composable(route = "login") {
            LoginScreen(
                onSignUpClick = { navController.navigate("signup") },
                onAuth = { navController.navigate("home") }
            )
        }

        // Sign-Up Screen
        composable(route = "signup") {
            SignUpScreen(
                onLoginClick = { navController.navigate("login") },
                onAuth = { navController.navigate("home") }
            )
        }

        // Home Screen
        composable(route = "home") {
            HomeScreen(
                navController
            )
        }

        // Car Entry Screen
        composable(route = "car_entry") {
            CarEntryScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }

        // Detail Screen
        composable(
            route = "detail/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")
            if (id != null) {
                Detail(id = id)
            }
        }
    }
}
