package com.boreal.allen.ui.seller.homesellercontainergraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.boreal.allen.domain.HOME_CONTAINER_SELLER_GRAPH
import com.boreal.allen.domain.SellerScreen

fun NavGraphBuilder.homeContainerSellerGraph(
    navController: NavHostController,
    closeApp: () -> Unit
) {
    navigation(
        startDestination = SellerScreen.HomeContainerSellerScreen.route,
        route = HOME_CONTAINER_SELLER_GRAPH
    ) {
        composable(route = SellerScreen.HomeContainerSellerScreen.route) {
            ViewHomeContainerSellerCompose(navController, closeApp)
        }
    }
}