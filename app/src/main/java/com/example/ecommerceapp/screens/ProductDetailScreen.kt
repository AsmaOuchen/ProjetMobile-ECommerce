package com.example.ecommerceapp.screens

import androidx.compose.foundation.Image
import com.example.ecommerceapp.models.Product
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProductDetailScreen(
    product: Product,
    onAddToCart: () -> Unit,
    onNavigateBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header avec bouton retour
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(onClick = onNavigateBack) {
                Text("← Back")
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Product Details",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Image du produit
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = product.name,
                modifier = Modifier.size(250.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Nom du produit
        Text(
            text = product.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Prix
        Text(
            text = "$${product.price}",
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Rating
        Text(
            text = "Rating: ${product.rating}",
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Description
        Text(
            text = "Description",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = product.description,
            fontSize = 16.sp,
            lineHeight = 24.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Détails supplémentaires
        Text(
            text = "Material: ${product.material}",
            fontSize = 14.sp
        )
        Text(
            text = "Sizes: ${product.sizeAvailability}",
            fontSize = 14.sp
        )
        Text(
            text = "Customer Ratings: ${product.customerRatings}",
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Bouton Ajouter au Panier
        Button(
            onClick = onAddToCart,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Add to Cart", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Barre de navigation
        MyBottomBar()
    }
}

@Composable
fun MyBottomBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(Icons.Default.Home, contentDescription = "Home")
            Text("Home", fontSize = 12.sp)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(Icons.Default.ShoppingCart, contentDescription = "Cart")
            Text("Cart", fontSize = 12.sp)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(Icons.Default.Person, contentDescription = "Profile")
            Text("Profile", fontSize = 12.sp)
        }
    }
}