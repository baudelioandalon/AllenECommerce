package com.boreal.allen.ui.seller.sales

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.boreal.allen.domain.SALES_SELLER_GRAPH
import com.boreal.allen.domain.SellerScreen

fun NavGraphBuilder.salesSellerGraph(navController: NavHostController, closeApp: () -> Unit) {
    navigation(
        startDestination = SellerScreen.SalesSellerScreen.route,
        route = SALES_SELLER_GRAPH
    ) {
        composable(route = SellerScreen.SalesSellerScreen.route) {
            ViewSalesSellerCompose(navController)
        }
    }
}