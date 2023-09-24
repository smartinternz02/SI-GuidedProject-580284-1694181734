package com.example.yumtum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import com.example.yumtum.ui.theme.YumRushTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val restaurantItems = listOf(
            RestaurantItem("PTK", "Rating: 4.9", R.drawable.restaurant1),
            RestaurantItem("GTK", "Rating: 4.8", R.drawable.restaurant2),
            RestaurantItem("C75", "Rating: 4.7", R.drawable.restaurant3)
        )

        setContent {
            YumRushTheme {
                val cartViewModel: CartViewModel = viewModel()
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "login"
                ) {
                    composable("login") {
                        LoginScreen(navController)
                    }
                    composable("restaurantList") {
                        RestaurantListScreen(navController, cartViewModel)
                    }
                    composable("restaurantDetails/{restaurantId}") { backStackEntry ->
                        val restaurantId = backStackEntry.arguments?.getString("restaurantId")
                        RestaurantDetailsScreen(navController, cartViewModel, restaurantId)
                    }
                    composable("restaurantItems/{restaurantId}") { backStackEntry ->
                        val restaurantId = backStackEntry.arguments?.getString("restaurantId")
                        RestaurantItemsScreen(navController, restaurantId ?: "", restaurantItems, cartViewModel)
                    }
                    composable("cart") {
                        CartScreen(navController, cartViewModel)
                    }
                }
            }
        }
    }
}
