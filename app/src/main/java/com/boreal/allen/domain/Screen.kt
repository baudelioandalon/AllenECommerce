package com.boreal.allen.domain

sealed class Screen(val route: String) {
    object WelcomeScreen : Screen("welcome_screen")
    object LoginScreen : Screen("login_screen")
    object RegisterScreen : Screen("register_screen")
}