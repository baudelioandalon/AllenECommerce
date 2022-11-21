package com.boreal.allen.ui.client.favorites

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.boreal.allen.domain.ClientScreen
import com.boreal.allen.domain.FAVORITES_GRAPH

fun NavGraphBuilder.favoritesGraph(navController: NavHostController, closeApp: () -> Unit) {
    navigation(
        startDestination = ClientScreen.FavoritesClientScreen.route,
        route = FAVORITES_GRAPH
    ) {
        composable(route = ClientScreen.FavoritesClientScreen.route) {
            ViewFavoritesCompose(navController)
        }
    }
}