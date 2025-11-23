package com.example.ecommerceapp.navigation

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object Login : Screen("login")
    object Signup : Screen("signup")
    object ProductList : Screen("product_list")
    object ProductDetail : Screen("product_detail")
    object Cart : Screen("cart")
}