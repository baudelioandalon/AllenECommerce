package com.boreal.allen.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.boreal.allen.domain.*
import com.boreal.allen.ui.client.addressclient.clientAddressGraph
import com.boreal.allen.ui.client.favorites.favoritesGraph
import com.boreal.allen.ui.client.homeclientgraph.homeClientGraph
import com.boreal.allen.ui.general.logingraph.loginGraph
import com.boreal.allen.ui.client.notificationclient.notificationClientGraph
import com.boreal.allen.ui.client.productgraph.productGraph
import com.boreal.allen.ui.client.productgraph.question.questionGraph
import com.boreal.allen.ui.client.productgraph.ratinggraph.ratingProductGraph
import com.boreal.allen.ui.client.result.general.resultClientGraph
import com.boreal.allen.ui.client.result.seller.resultBySellerClientGraph
import com.boreal.allen.ui.client.searchclient.searchClientGraph
import com.boreal.allen.ui.client.shopping.shoppingGraph
import com.boreal.allen.ui.client.shoppingcart.details.detailCartGraph
import com.boreal.allen.ui.client.shoppingcart.resume.resumeCartGraph
import com.boreal.allen.ui.client.shoppingcart.shoppingCartGraph
import com.boreal.allen.ui.client.shoppingdetail.shoppingDetail
import com.boreal.allen.ui.status.statusGraph
import com.boreal.allen.ui.general.storesmap.storesMapGeneralGraph
import com.boreal.allen.ui.seller.homesellercontainergraph.homeContainerSellerGraph

@Composable
fun MainCompose(closeApp: () -> Unit) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = HOME_CONTAINER_SELLER_GRAPH,
        route = ROOT_GRAPH
    ) {
        //General
        loginGraph(navController, closeApp)
        storesMapGeneralGraph(navController, closeApp)

        //Seller
        homeContainerSellerGraph(navController,closeApp)

        //Client
        homeClientGraph(navController, closeApp)
        searchClientGraph(navController, closeApp)
        resultClientGraph(navController, closeApp)
        resultBySellerClientGraph(navController, closeApp)
        productGraph(navController, closeApp)
        questionGraph(navController, closeApp)
        ratingProductGraph(navController, closeApp)
        shoppingCartGraph(navController, closeApp)
        detailCartGraph(navController, closeApp)
        resumeCartGraph(navController, closeApp)
        statusGraph(navController)
        clientAddressGraph(navController, closeApp)
        shoppingGraph(navController, closeApp)
        shoppingDetail(navController, closeApp)
        favoritesGraph(navController, closeApp)
        notificationClientGraph(navController, closeApp)
    }
}