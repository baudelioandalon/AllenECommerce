package com.boreal.allen.ui.productgraph.comment

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.boreal.allen.domain.ProductScreen
import com.boreal.allen.ui.productgraph.viewproduct.ViewProductCompose

const val COMMENT_GRAPH = "COMMENT_GRAPH"

fun NavGraphBuilder.commentGraph(navController: NavHostController, closeApp: () -> Unit) {
    navigation(startDestination = ProductScreen.ViewProductScreen.route, route = COMMENT_GRAPH) {
        composable(route = ProductScreen.ViewProductScreen.route) {
            ViewCommentCompose()
        }
    }
}