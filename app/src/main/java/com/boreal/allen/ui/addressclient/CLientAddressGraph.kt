package com.boreal.allen.ui.addressclient

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.boreal.allen.domain.ADDRESS_CLIENT_GRAPH
import com.boreal.allen.domain.ClientScreen
import com.boreal.allen.domain.SHOPPING_CART_GRAPH
import com.boreal.allen.domain.ShoppingCartScreen

fun NavGraphBuilder.clientAddressGraph(navController: NavHostController, closeApp: () -> Unit) {
    navigation(
        startDestination = ClientScreen.AddressClientScreen.route,
        route = ADDRESS_CLIENT_GRAPH
    ) {
        composable(route = ClientScreen.AddressClientScreen.route) {
            ViewAddressClientCompose()
        }
    }
}