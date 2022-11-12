package com.boreal.allen.ui.shoppingcart.details

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.boreal.allen.domain.SHOPPING_CART_GRAPH
import com.boreal.allen.domain.SHOPPING_DETAIL_GRAPH
import com.boreal.allen.domain.ShoppingCartScreen

fun NavGraphBuilder.detailCartGraph(navController: NavHostController, closeApp: () -> Unit) {
    navigation(
        startDestination = ShoppingCartScreen.ViewDetailCartScreen.route,
        route = SHOPPING_DETAIL_GRAPH
    ) {
        composable(route = ShoppingCartScreen.ViewDetailCartScreen.route) {
            ViewDetailCartCompose()
        }
    }
}