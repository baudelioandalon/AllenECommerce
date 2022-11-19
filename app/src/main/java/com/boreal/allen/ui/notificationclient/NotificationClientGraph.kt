package com.boreal.allen.ui.notificationclient

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.boreal.allen.domain.ClientScreen
import com.boreal.allen.domain.NOTIFICATION_CLIENT_GRAPH

fun NavGraphBuilder.notificationClientGraph(
    navController: NavHostController,
    closeApp: () -> Unit
) {
    navigation(
        startDestination = ClientScreen.NotificationClientScreen.route,
        route = NOTIFICATION_CLIENT_GRAPH
    ) {
        composable(route = ClientScreen.NotificationClientScreen.route) {
            ViewNotificationClientCompose(navController)
        }
    }
}