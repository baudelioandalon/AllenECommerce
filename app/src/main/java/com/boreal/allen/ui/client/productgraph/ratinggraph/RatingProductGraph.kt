package com.boreal.allen.ui.client.productgraph.ratinggraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.boreal.allen.domain.ProductScreen

const val RATING_PRODUCT_GRAPH = "RATING_PRODUCT_GRAPH"

fun NavGraphBuilder.ratingProductGraph(navController: NavHostController, closeApp: () -> Unit) {
    navigation(startDestination = ProductScreen.ViewRatingScreen.route, route = RATING_PRODUCT_GRAPH) {
        composable(route = ProductScreen.ViewRatingScreen.route) {
            ViewRatingProductCompose(navController)
        }
    }
}