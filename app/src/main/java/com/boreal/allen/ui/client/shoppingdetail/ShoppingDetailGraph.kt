package com.boreal.allen.ui.client.shoppingdetail

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.boreal.allen.domain.*

fun NavGraphBuilder.shoppingDetail(navController: NavHostController, closeApp: () -> Unit) {
    navigation(
        startDestination = ClientScreen.ShoppingDetailClientScreen.route,
        route = SHOPPING_DETAIL_CLIENT_GRAPH
    ) {
        composable(route = ClientScreen.ShoppingDetailClientScreen.route) {
            ViewShoppingDetailCompose(navController)
        }
    }
}