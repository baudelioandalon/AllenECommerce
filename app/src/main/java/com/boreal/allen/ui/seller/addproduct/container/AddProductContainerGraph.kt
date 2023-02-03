package com.boreal.allen.ui.seller.addproduct.container

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.boreal.allen.domain.ADD_PRODUCT_SELLER_GRAPH
import com.boreal.allen.domain.BUSSINESS_INFORMATION_SELLER_GRAPH
import com.boreal.allen.domain.HOME_CONTAINER_SELLER_GRAPH
import com.boreal.allen.domain.SellerScreen

fun NavGraphBuilder.addProductContainerGraph(
    navController: NavHostController,
    closeApp: () -> Unit
) {
    navigation(
        startDestination = SellerScreen.AddProductContainerScreen.route,
        route = ADD_PRODUCT_SELLER_GRAPH
    ) {
        composable(route = SellerScreen.AddProductContainerScreen.route) {
            ViewAddProductContainerCompose(navController, closeApp)
        }
    }
}