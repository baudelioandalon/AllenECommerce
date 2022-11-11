package com.boreal.allen.domain.model

data class ItemCartModel(
    val nameStore: String,
    val idStore: String,
    val imgStore: String,
    val listItems: List<ProductShoppingCart>
)

data class ProductShoppingCart(
    val skuProduct: String,
    val nameProduct: String,
    val imgProduct: String,
    val categoryItem: String,
    val quantity: Int,
    val discountPercentage: Double,
    val fastOrder: Boolean,
    val minimalFastOrder: Int,
    val price: Double
) {
    fun getProductWithDiscount() = if (discountPercentage > 0) {
        price - (price * (discountPercentage / 100))
    } else {
        price
    }
}