package com.boreal.allen.ui.client.shoppingcart

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.boreal.allen.domain.SHOPPING_CART_GRAPH
import com.boreal.allen.domain.ShoppingCartScreen

fun NavGraphBuilder.shoppingCartGraph(navController: NavHostController, closeApp: () -> Unit) {
    navigation(
        startDestination = ShoppingCartScreen.ViewShoppingCartScreen.route,
        route = SHOPPING_CART_GRAPH
    ) {
        composable(route = ShoppingCartScreen.ViewShoppingCartScreen.route) {
            ViewShoppingCartCompose(navController)
        }
    }
}