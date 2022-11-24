package com.boreal.allen.domain

const val HOME_CLIENT_GRAPH = "HOME_CLIENT_GRAPH"
const val SEARCH_CLIENT_GRAPH = "SEARCH_CLIENT_GRAPH"
const val RESULT_CLIENT_GRAPH = "RESULT_CLIENT_GRAPH"
const val RESULT_BY_SELLER_CLIENT_GRAPH = "RESULT_BY_SELLER_CLIENT_GRAPH"
const val ADDRESS_CLIENT_GRAPH = "ADDRESS_CLIENT_GRAPH"
const val SHOPPING_CLIENT_GRAPH = "SHOPPING_CLIENT_GRAPH"
const val FAVORITES_GRAPH = "FAVORITES_GRAPH"
const val NOTIFICATION_CLIENT_GRAPH = "NOTIFICATION_CLIENT_GRAPH"
const val STORES_MAPS_GENERAL_GRAPH = "STORES_MAPS_GENERAL_GRAPH"
const val SHOPPING_DETAIL_CLIENT_GRAPH = "SHOPPING_DETAIL_CLIENT_GRAPH"
const val STATUS_GRAPH = "STATUS_GRAPH"

sealed class ClientScreen(val route: String) {
    object HomeClientScreen : ClientScreen("home_client_screen")
    object SearchClientScreen : ClientScreen("search_client_screen")
    object ResultClientScreen : ClientScreen("result_client_screen")
    object ResultBySellerClientScreen : ClientScreen("result_by_seller_client_screen")
    object AddressClientScreen : ClientScreen("address_client_screen")
    object ShoppingClientScreen : ClientScreen("shopping_client_screen")
    object FavoritesClientScreen : ClientScreen("favorites_client_screen")
    object NotificationClientScreen : ClientScreen("notification_client_screen")
    object StoresMapGeneralScreen : ClientScreen("stores_maps_general_screen")
    object ShoppingDetailClientScreen : ClientScreen("shopping_detail_client_screen")
    object StatusClientScreen : ClientScreen("status_screen")
}