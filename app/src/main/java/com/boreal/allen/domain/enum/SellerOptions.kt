package com.boreal.allen.domain.enum

import com.boreal.allen.R

enum class SellerOptions(val title: String, val subtitle: String, val img: Int) {
    NEW_PRODUCT("Nuevo producto", "Añade más productos", R.drawable.new_product),
    NEW_STORE("Añadir sucursal", "Tengo una sucursal", R.drawable.add_store)
}