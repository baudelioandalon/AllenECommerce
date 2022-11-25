package com.boreal.allen.ui.seller.prepareshopping

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.boreal.allen.domain.PREPARE_SHOPPING_SELLER_GRAPH
import com.boreal.allen.domain.SellerScreen

fun NavGraphBuilder.prepareShoppingSellerGraph(
    navController: NavHostController,
    closeApp: () -> Unit
) {
    navigation(
        startDestination = SellerScreen.PrepareShoppingSellerScreen.route,
        route = PREPARE_SHOPPING_SELLER_GRAPH
    ) {
        composable(route = SellerScreen.PrepareShoppingSellerScreen.route) {
            ViewPrepareShoppingCompose(navController)
        }
    }
}