package com.boreal.allen.ui.favorites

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.boreal.allen.domain.ClientScreen
import com.boreal.allen.domain.FAVORITES_GRAPH
import com.boreal.allen.domain.SHOPPING_CART_GRAPH
import com.boreal.allen.domain.ShoppingCartScreen

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