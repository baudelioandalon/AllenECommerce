package com.boreal.allen.ui.seller.homesellergraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.boreal.allen.domain.ClientScreen
import com.boreal.allen.domain.HOME_CLIENT_GRAPH
import com.boreal.allen.domain.HOME_SELLER_GRAPH
import com.boreal.allen.domain.SellerScreen

fun NavGraphBuilder.homeSellerGraph(navController: NavHostController, closeApp: () -> Unit) {
    navigation(
        startDestination = SellerScreen.HomeSellerScreen.route,
        route = HOME_SELLER_GRAPH
    ) {
        composable(route = SellerScreen.HomeSellerScreen.route) {
            ViewHomeSellerCompose(navController, closeApp)
        }
    }
}