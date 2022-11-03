package com.boreal.allen.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.boreal.allen.domain.ROOT_GRAPH
import com.boreal.allen.ui.homeclientgraph.homeClientGraph
import com.boreal.allen.ui.logingraph.loginGraph
import com.boreal.allen.ui.productgraph.comment.COMMENT_GRAPH
import com.boreal.allen.ui.productgraph.comment.commentGraph
import com.boreal.allen.ui.productgraph.viewproduct.productGraph

@Composable
fun MainCompose(closeApp: () -> Unit) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = COMMENT_GRAPH,
        route = ROOT_GRAPH
    ) {
        loginGraph(navController, closeApp)
        homeClientGraph(navController, closeApp)
        productGraph(navController, closeApp)
        commentGraph(navController, closeApp)
    }
}