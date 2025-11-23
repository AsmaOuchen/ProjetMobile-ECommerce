package com.example.ecommerceapp.patterns

import com.example.ecommerceapp.models.CartItem

/**
 * ✅ PATTERN ITÉRATEUR - Pour parcourir le panier
 */
class CartIterator(val cartItems: List<CartItem>) : Iterator<CartItem> { // 'val' ajouté
    private var currentIndex = 0

    override fun hasNext(): Boolean {
        return currentIndex < cartItems.size
    }

    override fun next(): CartItem {
        if (!hasNext()) {
            throw NoSuchElementException("No more items in cart")
        }
        return cartItems[currentIndex++]
    }

    fun reset() {
        currentIndex = 0
    }

    fun getTotalPrice(): Double {
        return cartItems.sumOf { it.product.price * it.quantity }
    }
}