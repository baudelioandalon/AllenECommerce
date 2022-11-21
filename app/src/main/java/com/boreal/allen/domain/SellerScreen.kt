package com.boreal.allen.domain

const val HOME_SELLER_GRAPH = "HOME_SELLER_GRAPH"

sealed class SellerScreen(val route: String) {
    object HomeSellerScreen : SellerScreen("home_seller_screen")
}