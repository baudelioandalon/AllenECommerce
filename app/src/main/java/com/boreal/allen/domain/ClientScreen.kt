package com.boreal.allen.domain

const val HOME_CLIENT_GRAPH = "HOME_CLIENT_GRAPH"
const val ADDRESS_CLIENT_GRAPH = "ADDRESS_CLIENT_GRAPH"

sealed class ClientScreen(val route: String) {
    object HomeClientLoginScreen : ClientScreen("home_client_screen")
    object AddressClientScreen : ClientScreen("address_client_screen")
}