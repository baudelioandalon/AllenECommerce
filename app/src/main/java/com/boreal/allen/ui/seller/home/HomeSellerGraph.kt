package com.boreal.allen.ui.seller.home

import androidx.compose.material.ScaffoldState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.boreal.allen.domain.HOME_SELLER_GRAPH
import com.boreal.allen.domain.SellerScreen
import kotlinx.coroutines.CoroutineScope

fun NavGraphBuilder.homeSellerGraph(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
    scope: CoroutineScope,
    closeApp: () -> Unit
) {
    navigation(
        startDestination = SellerScreen.HomeSellerScreen.route,
        route = HOME_SELLER_GRAPH
    ) {
        composable(route = SellerScreen.HomeSellerScreen.route) {
            ViewHomeSellerCompose(scaffoldState, scope, navController)
        }
    }
}
