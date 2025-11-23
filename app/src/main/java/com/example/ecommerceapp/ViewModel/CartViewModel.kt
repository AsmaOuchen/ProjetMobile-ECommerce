// viewmodels/CartViewModel.kt
package com.example.ecommerceapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.ecommerceapp.models.CartItem
import com.example.ecommerceapp.models.Product
import java.util.UUID

class CartViewModel : ViewModel() {
    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems: StateFlow<List<CartItem>> = _cartItems

    fun addToCart(product: Product, size: String = "M") {
        viewModelScope.launch {
            val existingItem = _cartItems.value.find {
                it.product.id == product.id && it.size == size
            }

            if (existingItem != null) {
                _cartItems.value = _cartItems.value.map { item ->
                    if (item.product.id == product.id && item.size == size) {
                        item.copy(quantity = item.quantity + 1)
                    } else {
                        item
                    }
                }
            } else {
                _cartItems.value = _cartItems.value + CartItem(
                    id = UUID.randomUUID().toString(), // ✅ GÉNÉRER UN ID UNIQUE
                    product = product,
                    size = size,
                    quantity = 1
                )
            }
        }
    }

    fun removeFromCart(cartItemId: String) {
        viewModelScope.launch {
            _cartItems.value = _cartItems.value.filter { it.id != cartItemId }
        }
    }

    fun updateQuantity(cartItemId: String, newQuantity: Int) {
        viewModelScope.launch {
            if (newQuantity <= 0) {
                removeFromCart(cartItemId)
            } else {
                _cartItems.value = _cartItems.value.map { item ->
                    if (item.id == cartItemId) {
                        item.copy(quantity = newQuantity)
                    } else {
                        item
                    }
                }
            }
        }
    }

    fun getTotalPrice(): Double {
        return _cartItems.value.sumOf { it.product.price * it.quantity }
    }

    fun clearCart() {
        viewModelScope.launch {
            _cartItems.value = emptyList()
        }
    }
}