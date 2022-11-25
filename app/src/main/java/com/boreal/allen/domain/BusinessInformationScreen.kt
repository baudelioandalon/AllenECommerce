package com.boreal.allen.domain

const val BUSSINESS_INFORMATION_SELLER_GRAPH = "BUSSINESS_INFORMATION_SELLER_GRAPH"

sealed class BusinessInformationScreen(
    val route: String
) {
    object MainScreen : SellerScreen("main_bussiness_information_screen")
    object ContactInformationScreen : SellerScreen("contact_bussiness_information_screen")
    object ShippingAndPaymentsScreen : SellerScreen("shipping_and_payments_bussiness_information_screen")
    object PromotionScreen : SellerScreen("shipping_and_payments_bussiness_information_screen")
}