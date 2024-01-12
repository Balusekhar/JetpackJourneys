package com.example.jetpackjourneys.screens

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.jetpackjourneys.navigation.Routes
import com.example.jetpackjourneys.util.NavigationItem

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BlogList(navController: NavHostController) {
    Scaffold(
        content = {
            Text(text = "Home")
        },
        bottomBar = { BottomBar(navController) },
        floatingActionButton = {
            FabButton {
                navController.navigate(Routes.AddBlog.route)
            }
        }
    )
}

@Composable
fun BottomBar(navController: NavHostController) {

    val myNavItems = listOf(
        NavigationItem.Home,
        NavigationItem.Favourite,
        NavigationItem.About
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route
    var selectedIndex = myNavItems.indexOfFirst {
        it.route == currentDestination }


    NavigationBar {
        myNavItems.forEachIndexed { index, item ->
            NavigationBarItem(
                label = { Text(text = item.title) },
                selected = selectedIndex == index,
                onClick = {
                    selectedIndex = index
                    navController.navigate(item.route){
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = if (index == selectedIndex) {
                            item.selectedIcon
                        } else {
                            item.unselectedIcon
                        },
                        contentDescription = "Nav Item"
                    )

                }
            )
        }
    }
}



@Composable
fun FabButton(onFabClicked: () -> Unit) {
    FloatingActionButton(onClick = onFabClicked) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add"
        )
    }
}