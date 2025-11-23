package com.example.ecommerceapp.data

import com.example.ecommerceapp.R
import com.example.ecommerceapp.models.CartItem
import com.example.ecommerceapp.models.Product

val sampleProducts = listOf(
    Product(
        id = "1",
        name = "Alpine Ski Jackets",
        price = 129.99,
        imageRes = R.drawable.im2,
        rating = 4.5,
        description = "High-quality winter jacket designed for extreme cold conditions. Waterproof and breathable with premium insulation.",
        material = "Polyester/Nylon",
        sizeAvailability = "S, M, L, XL",
        customerRatings = "4.5/5 (128 reviews)"
    ),
    Product(
        id = "2",
        name = "Snowboard Pants",
        price = 299.99,
        imageRes = R.drawable.im3,
        rating = 4.8,
        description = "Professional snowboard for advanced riders. Perfect for freestyle and freeride with excellent edge control.",
        material = "Wood Core/Fiberglass",
        sizeAvailability = "150cm, 155cm, 160cm",
        customerRatings = "4.8/5 (64 reviews)"
    ),
    Product(
        id = "3",
        name = "Insulated Gloves",
        price = 45.99,
        imageRes = R.drawable.im4,
        rating = 4.2,
        description = "Thermal insulated gloves for extreme cold. Waterproof and touchscreen compatible.",
        material = "Thermal Insulation",
        sizeAvailability = "S, M, L",
        customerRatings = "4.2/5 (89 reviews)"
    ),
    Product(
        id = "4",
        name = "Winter Beanies",
        price = 89.99,
        imageRes = R.drawable.im5,
        rating = 4.6,
        description = "Waterproof winter boots with anti-slip sole. Perfect for snow and ice.",
        material = "Leather/Rubber",
        sizeAvailability = "38, 39, 40, 41, 42",
        customerRatings = "4.6/5 (156 reviews)"
    ),
    Product(
        id = "5",
        name = "Cashmere Scarves",
        price = 25.99,
        imageRes = R.drawable.im6,
        rating = 4.3,
        description = "Warm beanie hat made from premium wool. One size fits all.",
        material = "Wool/Acrylic",
        sizeAvailability = "One Size",
        customerRatings = "4.3/5 (203 reviews)"
    ),
    Product(
        id = "6",
        name = "Waterproof Hicking boots",
        price = 79.99,
        imageRes = R.drawable.im7,
        rating = 4.7,
        description = "Anti-fog ski goggles with UV protection. Perfect for all weather conditions.",
        material = "Polycarbonate/Silicone",
        sizeAvailability = "One Size",
        customerRatings = "4.7/5 (92 reviews)"
    )
)

val sampleCartItems = listOf(
    CartItem(
        id = "cart_1", // ✅ AJOUTEZ UN ID
        product = sampleProducts[0],
        size = "M",
        quantity = 1
    ),
    CartItem(
        id = "cart_2", // ✅ AJOUTEZ UN ID
        product = sampleProducts[2],
        size = "L",
        quantity = 2
    )
)