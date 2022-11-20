package com.boreal.allen.ui.homeclientgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.boreal.allen.domain.ClientScreen
import com.boreal.allen.domain.HOME_CLIENT_GRAPH

fun NavGraphBuilder.homeClientGraph(navController: NavHostController, closeApp: () -> Unit) {
    navigation(
        startDestination = ClientScreen.HomeClientLoginScreen.route,
        route = HOME_CLIENT_GRAPH
    ) {
        composable(route = ClientScreen.HomeClientLoginScreen.route) {
            AEHomeClientComposable(navController, closeApp)
        }
    }
}