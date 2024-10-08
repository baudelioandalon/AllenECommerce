package com.boreal.allen.ui.client.shopping

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.boreal.allen.domain.ClientScreen
import com.boreal.allen.domain.SHOPPING_CLIENT_GRAPH

fun NavGraphBuilder.shoppingGraph(navController: NavHostController, closeApp: () -> Unit) {
    navigation(
        startDestination = ClientScreen.ShoppingClientScreen.route,
        route = SHOPPING_CLIENT_GRAPH
    ) {
        composable(route = ClientScreen.ShoppingClientScreen.route) {
            ViewShoppingCompose(navController)
        }
    }
}