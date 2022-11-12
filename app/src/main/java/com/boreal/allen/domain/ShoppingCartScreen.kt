package com.boreal.allen.domain

const val SHOPPING_CART_GRAPH = "SHOPPING_CART_GRAPH"
const val SHOPPING_DETAIL_GRAPH = "SHOPPING_DETAIL_GRAPH"
const val SHOPPING_RESUME_GRAPH = "SHOPPING_RESUME_GRAPH"

sealed class ShoppingCartScreen(val route: String) {
    object ViewShoppingCartScreen : ShoppingCartScreen("view_shopping_cart_screen")
    object ViewDetailCartScreen : ShoppingCartScreen("view_detail_cart_screen")
    object ViewResumeCartScreen : ShoppingCartScreen("view_resume_cart_screen")
}