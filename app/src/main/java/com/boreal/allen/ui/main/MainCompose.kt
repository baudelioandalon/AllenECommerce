package com.boreal.allen.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.boreal.allen.domain.HOME_CLIENT_GRAPH
import com.boreal.allen.domain.LOGIN_GRAPH
import com.boreal.allen.domain.LoginScreen
import com.boreal.allen.domain.ROOT_GRAPH
import com.boreal.allen.ui.homeclientgraph.homeClientGraph
import com.boreal.allen.ui.logingraph.loginGraph
import com.boreal.allen.ui.logingraph.welcome.AEWelcomeCompose
import com.boreal.allen.ui.productgraph.PRODUCT_GRAPH
import com.boreal.allen.ui.productgraph.productGraph

@Composable
fun MainCompose(closeApp: () -> Unit) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = LOGIN_GRAPH,
        route = ROOT_GRAPH
    ) {
        loginGraph(navController, closeApp)
        homeClientGraph(navController, closeApp)
        productGraph(navController,closeApp)
    }
}