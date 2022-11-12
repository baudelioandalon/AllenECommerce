package com.boreal.allen.ui.shoppingcart.resume

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.boreal.allen.domain.SHOPPING_RESUME_GRAPH
import com.boreal.allen.domain.ShoppingCartScreen

fun NavGraphBuilder.resumeCartGraph(navController: NavHostController, closeApp: () -> Unit) {
    navigation(
        startDestination = ShoppingCartScreen.ViewResumeCartScreen.route,
        route = SHOPPING_RESUME_GRAPH
    ) {
        composable(route = ShoppingCartScreen.ViewResumeCartScreen.route) {
            ViewResumeCartCompose(navController)
        }
    }
}