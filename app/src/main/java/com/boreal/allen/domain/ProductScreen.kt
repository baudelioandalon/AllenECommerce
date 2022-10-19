package com.boreal.allen.domain

const val PRODUCT_GRAPH = "PRODUCT_GRAPH"

sealed class ProductScreen(val route: String) {
    object ViewProductScreen : LoginScreen("view_product_screen")
}