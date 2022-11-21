package com.boreal.allen.ui.status

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.boreal.allen.domain.ClientScreen
import com.boreal.allen.domain.STATUS_GRAPH
import com.boreal.allen.domain.enum.StatusEnum

fun NavGraphBuilder.statusGraph(
    navController: NavHostController, titleText: String = "",
    type: StatusEnum = StatusEnum.SUCCESS, subtitleText: String = "",
    bottomText: String = ""
) {
    navigation(
        startDestination = ClientScreen.StatusClientScreen.route,
        route = STATUS_GRAPH
    ) {
        composable(route = ClientScreen.StatusClientScreen.route) {
            ViewStatusCompose(navController, titleText, type, subtitleText, bottomText)
        }
    }
}