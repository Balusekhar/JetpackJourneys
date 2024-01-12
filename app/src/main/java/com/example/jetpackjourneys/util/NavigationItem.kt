package com.example.jetpackjourneys.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.jetpackjourneys.navigation.Routes

enum class NavigationItem(
    val title:String,
    val route:String,
    val selectedIcon:ImageVector,
    val unselectedIcon:ImageVector
){
    Home("Home",Routes.BlogList.route,Icons.Filled.Home,Icons.Outlined.Home),
    Favourite("Favorite",Routes.FavouriteBlogs.route,Icons.Filled.Favorite,Icons.Outlined.FavoriteBorder),
    About("About",Routes.AboutSection.route,Icons.Filled.AccountCircle,Icons.Outlined.AccountCircle)
}