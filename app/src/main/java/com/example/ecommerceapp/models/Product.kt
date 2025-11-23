package com.example.ecommerceapp.models

data class Product(
    val id: String,
    val name: String,
    val price: Double,
    val imageRes: Int,
    val rating: Double = 0.0,
    val description: String = "",
    val material: String = "Cotton",
    val sizeAvailability: String = "S, M, L, XL",
    val customerRatings: String = "4.5/5"
)