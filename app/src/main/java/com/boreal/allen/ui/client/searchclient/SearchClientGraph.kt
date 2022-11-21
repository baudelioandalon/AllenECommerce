package com.boreal.allen.ui.client.searchclient

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.boreal.allen.domain.ClientScreen
import com.boreal.allen.domain.SEARCH_CLIENT_GRAPH

fun NavGraphBuilder.searchClientGraph(navController: NavHostController, closeApp: () -> Unit) {
    navigation(startDestination = ClientScreen.SearchClientScreen.route, route = SEARCH_CLIENT_GRAPH) {
        composable(route = ClientScreen.SearchClientScreen.route) {
            ViewSearchClientCompose(navController, closeApp)
        }
    }
}