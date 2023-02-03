package com.boreal.allen.domain

const val BUSSINESS_INFORMATION_SELLER_GRAPH = "BUSSINESS_INFORMATION_SELLER_GRAPH"

sealed class BusinessInformationScreen(
    val route: String
) {
    object MainScreen : BusinessInformationScreen("main_bussiness_information_screen")
    object ContactInformationScreen : BusinessInformationScreen("contact_bussiness_information_screen")
    object ShippingAndPaymentsScreen : BusinessInformationScreen("shipping_and_payments_bussiness_information_screen")
    object PromotionScreen : BusinessInformationScreen("shipping_and_payments_bussiness_information_screen")
}