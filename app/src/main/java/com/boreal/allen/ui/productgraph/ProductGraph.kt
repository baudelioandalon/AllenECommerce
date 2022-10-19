package com.boreal.allen.ui.productgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.boreal.allen.domain.ProductScreen
import com.boreal.allen.ui.productgraph.viewproduct.ViewProductCompose

const val PRODUCT_GRAPH = "PRODUCT_GRAPH"

fun NavGraphBuilder.productGraph(navController: NavHostController, closeApp: () -> Unit) {
    navigation(startDestination = ProductScreen.ViewProductScreen.route, route = PRODUCT_GRAPH) {
        composable(route = ProductScreen.ViewProductScreen.route) {
            ViewProductCompose(navController)
        }
    }
}