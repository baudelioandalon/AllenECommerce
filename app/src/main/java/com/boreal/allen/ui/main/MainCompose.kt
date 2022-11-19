package com.boreal.allen.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.boreal.allen.domain.LOGIN_GRAPH
import com.boreal.allen.domain.ROOT_GRAPH
import com.boreal.allen.ui.addressclient.clientAddressGraph
import com.boreal.allen.ui.favorites.favoritesGraph
import com.boreal.allen.ui.homeclientgraph.homeClientGraph
import com.boreal.allen.ui.logingraph.loginGraph
import com.boreal.allen.ui.notificationclient.notificationClientGraph
import com.boreal.allen.ui.productgraph.productGraph
import com.boreal.allen.ui.productgraph.question.questionGraph
import com.boreal.allen.ui.productgraph.ratinggraph.ratingProductGraph
import com.boreal.allen.ui.shopping.shoppingGraph
import com.boreal.allen.ui.shoppingcart.details.detailCartGraph
import com.boreal.allen.ui.shoppingcart.resume.resumeCartGraph
import com.boreal.allen.ui.shoppingcart.shoppingCartGraph
import com.boreal.allen.ui.shoppingdetail.shoppingDetail
import com.boreal.allen.ui.storesmap.storesMapGeneralGraph

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
        productGraph(navController, closeApp)
        questionGraph(navController, closeApp)
        ratingProductGraph(navController, closeApp)
        shoppingCartGraph(navController, closeApp)
        detailCartGraph(navController, closeApp)
        resumeCartGraph(navController, closeApp)
        clientAddressGraph(navController, closeApp)
        shoppingGraph(navController, closeApp)
        shoppingDetail(navController, closeApp)
        favoritesGraph(navController, closeApp)
        notificationClientGraph(navController, closeApp)
        storesMapGeneralGraph(navController, closeApp)
    }
}