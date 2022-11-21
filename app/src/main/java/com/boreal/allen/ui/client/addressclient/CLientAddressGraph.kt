package com.boreal.allen.ui.client.addressclient

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.boreal.allen.domain.ADDRESS_CLIENT_GRAPH
import com.boreal.allen.domain.ClientScreen

fun NavGraphBuilder.clientAddressGraph(navController: NavHostController, closeApp: () -> Unit) {
    navigation(
        startDestination = ClientScreen.AddressClientScreen.route,
        route = ADDRESS_CLIENT_GRAPH
    ) {
        composable(route = ClientScreen.AddressClientScreen.route) {
            ViewAddressClientCompose(navController)
        }
    }
}