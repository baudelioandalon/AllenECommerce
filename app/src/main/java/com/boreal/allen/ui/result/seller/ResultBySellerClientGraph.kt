package com.boreal.allen.ui.result.seller

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.boreal.allen.domain.ClientScreen
import com.boreal.allen.domain.RESULT_BY_SELLER_CLIENT_GRAPH

fun NavGraphBuilder.resultBySellerClientGraph(
    navController: NavHostController,
    closeApp: () -> Unit
) {
    navigation(
        startDestination = ClientScreen.ResultBySellerClientScreen.route,
        route = RESULT_BY_SELLER_CLIENT_GRAPH
    ) {
        composable(route = ClientScreen.ResultBySellerClientScreen.route) {
            ViewResultBySellerClientCompose(navController, closeApp)
        }
    }
}