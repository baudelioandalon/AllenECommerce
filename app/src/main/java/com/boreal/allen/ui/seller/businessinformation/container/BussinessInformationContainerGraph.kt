package com.boreal.allen.ui.seller.businessinformation.container

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.boreal.allen.domain.BUSSINESS_INFORMATION_SELLER_GRAPH
import com.boreal.allen.domain.HOME_CONTAINER_SELLER_GRAPH
import com.boreal.allen.domain.SellerScreen

fun NavGraphBuilder.bussinessInformationContainerGraph(
    navController: NavHostController,
    closeApp: () -> Unit
) {
    navigation(
        startDestination = SellerScreen.HomeContainerSellerScreen.route,
        route = BUSSINESS_INFORMATION_SELLER_GRAPH
    ) {
        composable(route = SellerScreen.HomeContainerSellerScreen.route) {
            ViewBussinessInformationContainerCompose(navController, closeApp)
        }
    }
}