package com.example.yumtum

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantListScreen(navController: NavController, cartViewModel: CartViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TopAppBar(
            title = {
                Text(text = "YumTum - Yumm your Tummy")
            },
            modifier = Modifier.fillMaxWidth()
        )

        RestaurantListItemWithImage(
            "PTK",
            R.drawable.restaurant1,
            "Rating: 4.9",
        ) {
            navController.navigate("restaurantDetails/1")
        }

        RestaurantListItemWithImage(
            "GTK",
            R.drawable.restaurant2,
            "Rating: 4.8",
        ) {
            navController.navigate("restaurantDetails/2")
        }

        RestaurantListItemWithImage(
            "C75",
            R.drawable.restaurant3,
            "Rating: 4.7",
        ) {
            navController.navigate("restaurantDetails/3")
        }
    }
}
@Composable
fun RestaurantListItemWithImage(name: String, imageResId: Int, rating: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(4.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(text = name, style = MaterialTheme.typography.titleLarge)
                Text(text = rating, style = MaterialTheme.typography.bodySmall)
            }

            Spacer(modifier = Modifier.weight(1f))

            Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartIcon(navController: NavController, cartViewModel: CartViewModel) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                navController.navigate("cart")
            }
    ) {
        Icon(
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = null,
            tint = Color.Black
        )
        val cartItemCount = cartViewModel.getCartItemCount()
        if (cartItemCount > 0) {
            Badge {
                Text(
                    text = cartItemCount.toString(),
                    color = Color.White,
                    style = TextStyle(fontSize = 7.sp),
                )
            }
        }
    }
}
