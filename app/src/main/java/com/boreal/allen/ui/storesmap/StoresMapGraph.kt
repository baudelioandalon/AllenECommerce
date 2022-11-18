package com.boreal.allen.ui.storesmap

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.boreal.allen.domain.*

fun NavGraphBuilder.storesMapGeneralGraph(navController: NavHostController, closeApp: () -> Unit) {
    navigation(
        startDestination = ClientScreen.StoresMapGeneralScreen.route,
        route = STORES_MAPS_GENERAL_GRAPH
    ) {
        composable(route = ClientScreen.StoresMapGeneralScreen.route) {
            ViewStoresMapGeneralCompose(navController)
        }
    }
}