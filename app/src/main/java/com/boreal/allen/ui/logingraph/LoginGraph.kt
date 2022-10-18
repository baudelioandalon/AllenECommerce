package com.boreal.allen.ui.logingraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.boreal.allen.domain.LOGIN_GRAPH
import com.boreal.allen.domain.LoginScreen
import com.boreal.allen.ui.logingraph.login.AELoginCompose
import com.boreal.allen.ui.logingraph.register.AERegisterCompose
import com.boreal.allen.ui.logingraph.welcome.AEWelcomeCompose

fun NavGraphBuilder.loginGraph(navController: NavHostController, closeApp: () -> Unit) {
    navigation(
        startDestination = LoginScreen.WelcomeLoginScreen.route,
        route = LOGIN_GRAPH
    ) {
        composable(route = LoginScreen.WelcomeLoginScreen.route) {
            AEWelcomeCompose(navController)
        }
        composable(route = LoginScreen.LoginLoginScreen.route) {
            AELoginCompose(navController)
        }
        composable(route = LoginScreen.RegisterLoginScreen.route) {
            AERegisterCompose(navController)
        }
    }
}