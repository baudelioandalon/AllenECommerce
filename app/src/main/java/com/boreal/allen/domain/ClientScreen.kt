package com.boreal.allen.domain

const val HOME_CLIENT_GRAPH = "HOME_CLIENT_GRAPH"

sealed class ClientScreen(val route: String) {
    object HomeClientLoginScreen : ClientScreen("home_client_screen")
}