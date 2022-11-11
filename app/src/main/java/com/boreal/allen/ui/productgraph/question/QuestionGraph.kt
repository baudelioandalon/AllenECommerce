package com.boreal.allen.ui.productgraph.question

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.boreal.allen.domain.ProductScreen

const val QUESTION_GRAPH = "QUESTION_GRAPH"

fun NavGraphBuilder.questionGraph(navController: NavHostController, closeApp: () -> Unit) {
    navigation(startDestination = ProductScreen.ViewQuestionScreen.route, route = QUESTION_GRAPH) {
        composable(route = ProductScreen.ViewQuestionScreen.route) {
            ViewQuestionCompose(navController)
        }
    }
}