package com.boreal.allen.domain.model

data class ItemShoppingModel(
    val nameStore: String,
    val idStore: String,
    val imgStore: String,
    val idSale: String,
    val price: Double,
    val status: String,
    val numberProducts: Int,
    val giftStatus: String,
    val apologyStatus: String,
    val canceledBy: String
)