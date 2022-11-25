package com.boreal.allen.domain

import com.boreal.allen.R

const val HOME_SELLER_GRAPH = "HOME_SELLER_GRAPH"
const val HOME_CONTAINER_SELLER_GRAPH = "HOME_SELLER_GRAPH"
const val SALES_SELLER_GRAPH = "SALES_SELLER_GRAPH"
const val PREPARE_SHOPPING_SELLER_GRAPH = "PREPARE_SHOPPING_SELLER_GRAPH"

sealed class SellerScreen(
    val route: String,
    val icon: Int = R.drawable.ic_home,
    val title: String = ""
) {
    object HomeContainerSellerScreen : SellerScreen("home_container_seller_screen", R.drawable.ic_home, "Home")
    object HomeSellerScreen : SellerScreen("home_seller_screen", R.drawable.ic_home, "Home")
    object ProductsSellerScreen : SellerScreen("products_seller_screen", R.drawable.ic_cart_icon, "Productos")
    object SalesSellerScreen : SellerScreen("sales_seller_screen")
    object PrepareShoppingSellerScreen : SellerScreen("prepare_shopping_seller_screen")
}