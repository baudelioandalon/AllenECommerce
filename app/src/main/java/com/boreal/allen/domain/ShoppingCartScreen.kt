package com.boreal.allen.domain

const val SHOPPING_CART_GRAPH = "SHOPPING_CART_GRAPH"

sealed class ShoppingCartScreen(val route: String) {
    object ViewShoppingCartScreen : ShoppingCartScreen("view_shopping_cart_screen")
}