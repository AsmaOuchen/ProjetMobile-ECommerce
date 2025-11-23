package com.example.ecommerceapp.patterns

import com.example.ecommerceapp.models.Product

/**
 * ✅ PATTERN ITÉRATEUR - Pour parcourir les produits
 */
class ProductIterator(val products: List<Product>) : Iterator<Product> { // 'val' ajouté
    private var currentIndex = 0

    override fun hasNext(): Boolean {
        return currentIndex < products.size
    }

    override fun next(): Product {
        if (!hasNext()) {
            throw NoSuchElementException("No more products available")
        }
        return products[currentIndex++]
    }

    fun reset() {
        currentIndex = 0
    }

    fun getCurrentIndex(): Int = currentIndex
}