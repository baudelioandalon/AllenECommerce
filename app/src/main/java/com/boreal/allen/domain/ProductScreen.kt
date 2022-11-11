package com.boreal.allen.domain

const val PRODUCT_GRAPH = "PRODUCT_GRAPH"

sealed class ProductScreen(val route: String) {
    object ViewProductScreen : ProductScreen("view_product_screen")
    object ViewRatingScreen : ProductScreen("view_rating_screen")
    object ViewQuestionScreen : ProductScreen("view_question_screen")
}