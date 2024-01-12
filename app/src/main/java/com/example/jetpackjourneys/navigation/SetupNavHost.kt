package com.example.jetpackjourneys.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.jetpackjourneys.screens.AboutScreen
import com.example.jetpackjourneys.screens.AddBlog
import com.example.jetpackjourneys.screens.BlogList
import com.example.jetpackjourneys.screens.FavoriteBlogs
import com.example.jetpackjourneys.screens.LoginScreen
import com.example.jetpackjourneys.screens.SignUpScreen
import com.example.jetpackjourneys.util.NavigationItem

@Composable
fun NavHost(
    navController: NavHostController,
) {

    NavHost(
        navController = navController,
        startDestination = Routes.AuthGraph.route
    ) {

        navigation(
            route = Routes.AuthGraph.route,
            startDestination = Routes.Login.route
        ){
            composable(Routes.Login.route) {
                LoginScreen(navController)
            }

            composable(Routes.Signup.route) {
                SignUpScreen()
            }
        }

        navigation(
            route = Routes.HomeGraph.route,
            startDestination = Routes.BlogList.route
        ){
            composable(Routes.BlogList.route){
                BlogList(navController)
            }

            composable(Routes.AddBlog.route){
                AddBlog()
            }

            composable(Routes.FavouriteBlogs.route){
                FavoriteBlogs(navController)
            }

            composable(Routes.AboutSection.route){
                AboutScreen(navController)
            }
        }
    }
}


//fun getRouteForNavigationItem(item: NavigationItem): String {
//    return when (item) {
//        NavigationItem.Home -> Routes.BlogList.route
//        NavigationItem.Favourite -> Routes.FavouriteBlogs.route
//        NavigationItem.About -> Routes.AboutSection.route
//    }
//}
//
