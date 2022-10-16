package com.boreal.allen.ui.start

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.boreal.allen.ui.login.AELoginCompose
import com.boreal.allen.ui.register.AERegisterCompose
import com.boreal.allen.ui.welcome.AEWelcomeCompose

@Composable
fun MainCompose() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.WelcomeScreen.route) {
        composable(route = Screen.WelcomeScreen.route) {
            AEWelcomeCompose(navController)
        }
        composable(route = Screen.LoginScreen.route) {
            AELoginCompose(navController)
        }
        composable(route = Screen.RegisterScreen.route) {
            AERegisterCompose(navController)
        }
    }
}

sealed class Screen(val route: String) {
    object WelcomeScreen : Screen("welcome_screen")
    object LoginScreen : Screen("login_screen")
    object RegisterScreen : Screen("register_screen")
}