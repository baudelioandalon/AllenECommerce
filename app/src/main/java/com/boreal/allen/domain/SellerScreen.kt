package com.boreal.allen.domain

import com.boreal.allen.R

const val HOME_SELLER_GRAPH = "HOME_SELLER_GRAPH"
const val HOME_CONTAINER_SELLER_GRAPH = "HOME_SELLER_GRAPH"
const val MY_PRODUCTS_SELLER_GRAPH = "MY_PRODUCTS_SELLER_GRAPH"

sealed class SellerScreen(val route: String, val icon: Int, val title: String) {
    object HomeContainerSellerScreen : SellerScreen("home_container_seller_screen", R.drawable.ic_home, "Home")
    object HomeSellerScreen : SellerScreen("home_seller_screen", R.drawable.ic_home, "Home")
    object ProductsSellerScreen : SellerScreen("products_seller_screen", R.drawable.ic_cart_icon, "Productos")
}