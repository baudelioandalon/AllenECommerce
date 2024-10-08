package com.boreal.allen.ui.client.result.general

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.boreal.allen.domain.ClientScreen
import com.boreal.allen.domain.RESULT_CLIENT_GRAPH

fun NavGraphBuilder.resultClientGraph(navController: NavHostController, closeApp: () -> Unit) {
    navigation(
        startDestination = ClientScreen.ResultClientScreen.route,
        route = RESULT_CLIENT_GRAPH
    ) {
        composable(route = ClientScreen.ResultClientScreen.route) {
            ViewResultClientCompose(navController, closeApp)
        }
    }
}