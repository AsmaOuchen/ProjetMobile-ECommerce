// models/CartItem.kt
package com.example.ecommerceapp.models

data class CartItem(
    val id: String, // ✅ AJOUTEZ CETTE LIGNE
    val product: Product,
    val size: String = "M",
    val quantity: Int = 1
)