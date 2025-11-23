// navigation/Navigation.kt
package com.example.ecommerceapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ecommerceapp.data.sampleProducts
import com.example.ecommerceapp.patterns.ProductIterator
import com.example.ecommerceapp.screens.*
import com.example.ecommerceapp.models.Product
import com.example.ecommerceapp.viewmodels.CartViewModel

@Composable
fun NavigationStack() {
    val navController = rememberNavController()
    val cartViewModel: CartViewModel = viewModel() // ✅ AJOUTEZ CETTE LIGNE

    val productIterator = ProductIterator(sampleProducts)

    NavHost(navController = navController, startDestination = Screen.Welcome.route) {
        composable(Screen.Welcome.route) {
            WelcomeScreen(
                onNavigateToLogin = { navController.navigate(Screen.Login.route) }
            )
        }

        composable(Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Screen.ProductList.route)
                },
                onNavigateToSignup = { navController.navigate(Screen.Signup.route) },
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(Screen.Signup.route) {
            SignupScreen(
                onSignupSuccess = {
                    navController.navigate(Screen.ProductList.route)
                },
                onNavigateToLogin = { navController.navigate(Screen.Login.route) }
            )
        }

        composable(Screen.ProductList.route) {
            ProductListScreen(
                productIterator = productIterator,
                onProductClick = { product ->
                    navController.navigate("product_detail/${product.id}")
                },
                onNavigateToCart = { navController.navigate(Screen.Cart.route) },
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(
            route = "product_detail/{productId}",
            arguments = listOf(navArgument("productId") { type = NavType.StringType })
        ) { backStackEntry ->
            val productId: String? = backStackEntry.arguments?.getString("productId")
            val product = findProductById(productId, sampleProducts)

            ProductDetailScreen(
                product = product,
                onAddToCart = {
                    cartViewModel.addToCart(product) // ✅ MODIFIEZ CETTE LIGNE
                    navController.navigate(Screen.Cart.route)
                },
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(Screen.Cart.route) {
            CartScreen(
                cartViewModel = cartViewModel, // ✅ MODIFIEZ CETTE LIGNE
                onCheckout = {
                    cartViewModel.clearCart()
                    navController.navigate(Screen.ProductList.route) {
                        popUpTo(Screen.ProductList.route) { inclusive = true }
                    }
                },
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}

private fun findProductById(productId: String?, products: List<Product>): Product {
    return products.find { it.id == productId } ?: products.first()
}