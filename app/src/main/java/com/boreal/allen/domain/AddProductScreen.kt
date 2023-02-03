package com.boreal.allen.domain

const val ADD_PRODUCT_SELLER_GRAPH = "ADD_PRODUCT_SELLER_GRAPH"

sealed class AddProductScreen(
    val route: String
) {
    object MainScreen : AddProductScreen("main_add_product_screen")
    object CategoryScreen : AddProductScreen("category_screen")
    object DetailScreen : AddProductScreen("detail_screen")
    object PriceScreen : AddProductScreen("price_screen")
    object TagsScreen : AddProductScreen("tags_screen")
}