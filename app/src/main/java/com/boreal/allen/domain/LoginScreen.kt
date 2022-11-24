package com.boreal.allen.domain

const val ROOT_GRAPH = "ROOT_GRAPH"
const val ROOT_SELLER_GRAPH = "ROOT_SELLER_GRAPH"
const val LOGIN_GRAPH = "LOGIN_GRAPH"

sealed class LoginScreen(val route: String) {
    object WelcomeLoginScreen : LoginScreen("welcome_screen")
    object LoginLoginScreen : LoginScreen("login_screen")
    object RegisterLoginScreen : LoginScreen("register_screen")
}